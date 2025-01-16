#  Problem: Find the missing number in a sorted array.
#  Time Complexity: O(logN)
# Space Complexity: O(1)


def find_missing_number(arr):
    left, right = 0, len(arr) - 1

    while left <= right:
        mid = (left + right) // 2
        
        if arr[mid] == mid + arr[0]:
            left = mid + 1
        else:
            right = mid - 1

    return left + arr[0]
