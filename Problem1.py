#
# Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range
# that is missing from the array.
# // Time Complexity :
# // Space Complexity :
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach

# Step 1: Read Question
# Step 2: Constraints
# Step 3: Test Cases
#         [0, 1, 3, 4, 6, 7] --> 2
#         [0, 1, 2, 3, 4, 5, 6, 7, 9] --> 8
#         [0, 2, 3, 4, 5, 6, 7] --> 8
# Step 4: Solution without Code
#         Brute Force: Linear Search
#         Optimised: Binary Search --> finding the difference between the index and the num[i]
#         else go where missing high = mid - 1
# Step 5: Code the solution

class Solution:
    def missingNumber(self, nums):
        # two ptrs low
        low = 0
        # and high
        high = len(nums) - 1
        # binary search
        while ((high - low) >= 2):
            # calculate mid
            mid = (low + high) // 2
            # find difference between the index and the nums[i] to find which part the missing number is
            mid_dif = nums[mid] - mid
            low_dif = nums[low] - low
            high_dif = nums[high] - high
            # if index_diff is different then missing number in left part
            if mid_dif != low_dif:
                high = mid
            # if index_diff is different then missing number in right part
            elif mid_dif != high_dif:
                low = mid
        # returning missing number
        return (nums[low] + nums[high]) // 2


nums = [0, 1, 2, 4, 5, 6, 7]

# nums = [0, 1, 2, 3, 4, 5, 6, 7, 9]
# nums = [0, 1, 3, 4, 6, 7]
sol = Solution()
print(sol.missingNumber(nums))
