# Time COmplexity: O(n)
# Space COmplexity: O(1)
# Leetcode run : yes


class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        
        nums.sort()
        
        
        l=0
        r=len(nums)-1
        
        while l<=r:
            
            mid = l+(r-l)//2
            
            if mid == nums[mid]:
                l = mid+1
            
            else:
                r= mid-1
            
        return l
    
            
        
        