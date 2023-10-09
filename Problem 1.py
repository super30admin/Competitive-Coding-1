#LC: NA
#problems: return mid + 1, intead of low +! , :/, realised later
#TC: O(logn)
#SC: O(1)

#Missing number in a sorted array
class Solution:
    def missingElement(self, nums):
        
        if nums is None or len(nums) == 0:
            return -1
            
        low = 0
        high = len(nums) - 1
        
        while low < high:
            mid = low + (high - low)//2
            if nums[mid] != mid + 1:
                high = mid
                
            else:
                low = mid + 1
        return low + 1
        
sol = Solution()
print(sol.missingElement([1,2,3,4,5,6,8]))