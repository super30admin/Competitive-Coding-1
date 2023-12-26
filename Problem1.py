# Find the missing number in a sorted array of integers
#time complexity: O(logn)
#space complexity: O(1)

def search(arr, size):
    low = 0
    high = size - 1
    mid = 0

    while high - low >= 2:
        mid = low + (high - low) // 2
        mid_index_diff = arr[mid] - mid
        low_index_diff = arr[low] - low

        if mid_index_diff != low_index_diff:
            high = mid
        else:
            low = mid

    return (arr[low] + arr[high]) // 2


if __name__ == "__main__":
    arr = [1, 2, 3, 4, 5, 7, 8]
    size = len(arr)
    print("Missing number:", search(arr, size))
