from typing import List


class Solution(object):
    def FindMissingNum(self, nums):
        # null case
        if nums == None or not nums: return -1
        low, high = 0, len(nums) - 1
        while(low <= high):
            mid = (low + high) // 2
            if mid == 0 or not(nums[mid] - nums[mid - 1] == 1):
                return nums[mid] - 1
            elif mid == len(nums) - 1 or not (nums[mid + 1] - nums[mid] == 1):
                print('here')
                return nums[mid] + 1
            
sol = Solution()
print(sol.FindMissingNum([1,2,4,5]))