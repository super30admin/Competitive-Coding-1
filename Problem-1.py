#Time Complexity : O(n logn)
#Space Complexity : O(1)

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        lo, hi = 0, len(nums)-1
        nums.sort()

        while lo <= hi:
            mid = (lo+hi)//2

            if nums[mid] > mid:
                hi = mid - 1
            elif nums[mid] == mid:
                lo = mid + 1
        
        return lo