Time Complexity : O(logn)
Space Complexity : O(1)
Runs on LeetCode : Yes
Doubts :  No


class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
         # Ensure that n is at the last index
        if nums[-1] != len(nums):
            return len(nums)
        # Ensure that 0 is at the first index
        elif nums[0] != 1:
            return 1
        
        while(low <= high):
            mid = low + (high - low)//2
            if nums[mid] != mid-1 and nums[mid - 1] == mid - 2:
                return mid - 1
            if nums[mid] != mid - 1 :
                high = mid - 1
            else :
                low = mid + 1
        
            
        