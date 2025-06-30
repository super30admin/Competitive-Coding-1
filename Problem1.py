#Binary Search
#Time Complexity: O(log n)
#Space Complexity: O(1)

def missingNumber(self, arr):
    low = 0
    high = len(arr) - 1
    while (high - low) > 1:
        mid = (low + high) // 2
        if (arr[low] - low) != (arr[mid] - mid):
            high = mid
        elif (arr[high] - high) != (arr[mid] - mid):
            low = mid
    return arr[low] + 1
