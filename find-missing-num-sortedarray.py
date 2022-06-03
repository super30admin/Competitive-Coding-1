class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        nums.sort()    
        low=0
        high=len(nums)-1
        n=len(nums)-1
        
        while low<=high:
            mid=low+(high-low)//2
            print("mid", mid, ",",nums[mid])
            print("l=", low, ", high=", high)                      
            if nums[mid]!=mid:
                print("1")
                high=mid-1
            elif nums[mid]==mid:
                print("2")
                low=mid+1
        return low