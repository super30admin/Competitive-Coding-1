# Time complexity: O(log n)
# Space complexity: O(1)
# Did this code run successfully on Leetcode: Yes
# Any difficulty faced: I need to practice more in order to problem solve more efficiently.

# Approach:
# 1. Since the numbers are already sorted, all the numbers should correspond to respective index+1.
# 2. If the element at index i is i+1, it implies that all the numbers leading up to the mid are present in the array, and so we need to search in the right half.
# 3. If the element at index i is not i+1, it implies that the missing number is in the left half.
# 4. We continue this process until we find the missing number.
class Solution:
    def binarySearch(self, arr) -> int:
        l, h = 0, len(arr) - 1
        while l <= h:
            mid = l + (h - l)//2
            if arr[mid] == mid+1:
                l = mid + 1
            else:
                h = mid - 1
        return l+1