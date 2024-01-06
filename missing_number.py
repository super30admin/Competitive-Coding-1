class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        nums.sort()
        low = 0
        high  = len(nums) - 1
        while low <= high:
            mid = (low+high) // 2
            if mid == nums[mid]: 
                low = mid + 1
            else:
                high = mid - 1
        return low 



