"""
# Problem: Given a finite array with no duplicates, find missing element
# Example:
    Input - [1,3,4,5,6,7]
    Output - 2
# Solution:
    - Use binary search tree
    - With the help of difference between index's and numbers of mid and left,
    - decide which side the missing number could belong
# Time Complexity - O(log n), using binary search, where n is the number of elements in the array
# Space Complexity - O(1)
"""


class Solution:
    def find_missing_element(self, nums):
        # Corner cases
        if len(nums) is 0 or nums is None:
            return -1
        elif nums[0] != 1:
            return 1

        # two pointers
        left = 0
        right = len(nums)-1

        # Binary search
        while left <= right:
            mid = int(left + (right-left)/2)
            # Check the difference between index's and numbers of mid and left
            if (mid - left) == (nums[mid]-nums[left]):
                # If same, missing number is on the right side of mid
                left = mid+1
            else:
                # If not same, missing number is on the left side of mid
                right = mid-1
        # when left, mid and right are equal, return (num-1)
        return nums[mid]-1


# Driver code
obj = Solution()
# Test Cases:
# 1. Missing element in the first half
print(obj.find_missing_element([1,3,4,5,6,7]))
# 2. Missing element in the second half
print(obj.find_missing_element([1,2,3,4,5,7]))
# 3. Missing element is the first element
print(obj.find_missing_element([2,3,4,5,6,7]))