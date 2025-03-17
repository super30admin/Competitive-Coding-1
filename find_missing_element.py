# space complexity: O(1)
# Time Complexity: O(log(n)
class Solution:
    # def __init__(self, nums: []):
    #     pass
    def findmissing(self, nums):
        low= 0
        high= len(nums)-1
        
        if (len(nums)==0):
            return
        if(nums[0] != 1):
            return 1
        
        while( low <= high):
            mid = low + (high-low)//2
            if (mid == high) or (mid == low):
                return -1
            if (nums[mid+1]- nums[mid]) != 1:
                return nums[mid ] +1
            if (nums[mid]- nums[mid-1]) != 1:
                return nums[mid] -1
            
            if (nums[mid] == mid+1):
                low = mid +1
            else:
                high = mid -1
        return -1
sol = Solution()
res= sol.findmissing([1,2,3,4,5,6,7])
print(res)

                
            
