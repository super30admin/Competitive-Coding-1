class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        nums = sorted(nums)
        if len(nums) == 0 or nums == []:
            return 1
        
        low = 0 
        high = len(nums)
        while low < high: 
            mid = int((low+high)/2)
            print(mid)
            
            if mid < nums[mid]:
                high = mid
            else:
                low = mid + 1
        
        return low
    
# used binary search algo for this, if at mid mid and value of mid are not equal then we will shift the high pointer, if reverse will shift the low pointer.
