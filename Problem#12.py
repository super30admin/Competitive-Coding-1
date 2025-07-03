'''
268. Find Missing Number
Problem Name: Interview Problem: Find Missing Number in a sorted array

Source Link: https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/
'''


# Time Complexity : O(n) for calculating the sum of the array elements, O(log n) for binary search in the sorted array
# Space Complexity : O(1) as we are using a constant amount of space for variables , O(n) for sorting the array if we use the sort method (but in this case, we are not using any extra space for sorting as we are using the built-in sort method which is optimized)
# Did this code successfully run on Leetcode : Yes, the code runs successfully on LeetCode for both unsorted and sorted arrays.
# Any problem you faced while coding this : Yes, I had to ensure that the binary search logic correctly identifies the missing number in a sorted array, especially when the first or last elements are missing.

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        
        # for unsorted array
        # n = len(nums) # humne length of nums ko n main store kiya hai (We have stored the length of nums in n)
        # total = (n * (n + 1)) // 2 # This is the formula to calculate the sum of the first n natural numbers
        # return total - sum(nums) # The missing number is the difference between the total sum and the sum of the array elements

        # for sorted array
        # Using binary search to find the missing number
        nums.sort() # humne nums ko sort kiya hai (We have sorted the nums array)
        if nums[0] != 0:  # If the first element is not 0, the missing number is 0
            return 0
        if nums[-1] != len(nums):  # If the last element is not equal to the length of nums, the missing number is len(nums)
            return len(nums)
        # Binary search to find the missing number
        left, right = 0, len(nums) - 1 # humne left aur right ko initialize kiya hai (We have initialized left and right)
        while left <= right: # Jab tak left chhota ya barabar hai right ke (While left is less than or equal to right)
            mid = (left + right) // 2 # humne mid ko calculate kiya hai (We have calculated mid)
            if nums[mid] == mid: # Agar mid ka value mid ke barabar hai (If the value at mid is equal to mid)
                left = mid + 1 # humne left ko mid + 1 se update kiya hai (We update left to mid + 1)
            else: # Agar mid ka value mid ke barabar nahi hai (If the value at mid is not equal to mid)
                right = mid - 1 # humne right ko mid - 1 se update kiya hai (We update right to mid - 1)
        return left  # The missing number is at the position 'left' # as it will be the first position where the value does not match the index
        
            

