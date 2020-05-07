# Time Complexity : O( log N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode :no, executed in PyCharm
# Any problem you faced while coding this : no
def search(arr, size):
    low = 0
    high = size - 1
    mid = 0
    while high > low + 1:
        mid = low + (high - low) // 2
        midIndexDiff = arr[mid] - mid
        lowIndexDiff = arr[low] - low
        highIndexDiff = arr[high] - high
        if midIndexDiff != lowIndexDiff:
            high = mid
        elif midIndexDiff != highIndexDiff:
            low = mid
    return (arr[low] + arr[high]) // 2


arr = [1, 2, 3, 5]
size = len(arr)

print("Missing number:", search(arr, size))
