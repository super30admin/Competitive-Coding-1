# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : No, problem not present on leetcode, ran on local
# Any problem you faced while coding this : yes

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        start,end,mid = 0,len(nums)-1,0
        while end-start >= 2:
            mid = start + (end-start)//2
            midDiff = nums[mid]-mid
            startDiff = nums[start]-start
            endDiff = nums[end]-end
            if midDiff != startDiff:
                end = mid
            elif midDiff != endDiff:
                start = mid
        return ((nums[start]+nums[end])//2)
        
