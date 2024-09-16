# Find Missing Number in a sorted array
# Time Complexity: O(log(n))
# Space Complexity: O(1)
# No Problems 
def find_missing_element(arr):

    left = 0

    right = len(arr) - 1

    while left <= right:
            
        if left == right:

            return left + 1

        mid = left + (right - left) // 2

        if arr[mid] - mid > 1:

            right = mid
        else:
            left = mid + 1


arr = [1,2,3,5,6,7]
print(find_missing_element(arr))


