# problem 1 

# https://leetcode.com/problems/missing-element-in-sorted-array/

class Solution:
    def missingElement(self, nums: List[int], k: int) -> int:
        high = len(nums)-1
        low = 0 
        while(low<high):
            mid = high - (high-low)//2
            if(nums[mid]-nums[0]) - mid < k:
                low = mid
            else:
                high = mid-1 
        return nums[0]+k+low