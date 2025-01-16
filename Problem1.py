
"""
Question is find the missing element in the array:
clarifying questions to ask:
- if array is sequential
- if size of array is given ( what if missing element is at the start)
- are there any duplicates in array
- is array sorted
- what should I return ? index or missing element

Brute Force:
    arr = [2,5,6,7,8,9,11]
    Time complexity : O(N)

Optimized approah:
    Binary Search, intinution is diff between index and the elemnt itself can be a moving condition
if diff between index and element is greater than 1 then missing elemnt lies to the right.
    
"""


def binarySearch(low: int, high: int, arr: list) -> int:
    # Base condition
    if low > high:
        return -1

    mid = low + (high - low) // 2

    diffLow = arr[low] - low
    diffHigh = arr[high] - high
    diffMid = arr[mid + 1] - arr[mid]

    if diffMid != 1:
        return mid

    if diffLow != 1:
        # Move left
        high = mid - 1
        return binarySearch(low, high, arr)

    if diffHigh != 1:
        # Move right
        low = mid + 1
        return binarySearch(low, high, arr)


def main():
    arr = [1, 2, 3, 4, 5, 6, 8, 9]  # Change this to test with different arrays
    res = 0

    if len(arr) == 1:
        res = -1

    if arr is None:
        res = -1

    low = 0
    high = len(arr) - 1

    if res == 0:
        res = binarySearch(low, high, arr)

    if res == -1:
        print("Nothing is missing")
    else:
        print("Missing element:", arr[res] + 1)


if __name__ == "__main__":
    main()
