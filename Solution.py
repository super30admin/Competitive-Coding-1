"""
Time Complexity Log n 
Space complexity O(1)

1. Sort the number. Find Mid 
2. If nums[mid] is equal to mid then move right side, 
3. If nusm[mid] not equal to mid move left side 
4. when low index surpass high ie low>high , return low which is the missing element 

"""
class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        if nums is None:
            return -1
        
        nums.sort()
        low=0
        high=len(nums)-1
        while(low<=high):
            mid=low+(high-low)//2 
            if(nums[mid]==mid):
                low=mid+1
            else:
                high=mid-1
    
        return low 
    
        
        