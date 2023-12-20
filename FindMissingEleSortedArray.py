#

#Time complexity : (logn) 
#space complexity: O(1)

class Solution:
    def missingElement(self, nums: List[int], k: int) -> int:
        low = 0 
        n = len(nums)
        high = n-1 
        while(low<high):
            mid =  high - (high - low) // 2
           # mid =(low + high) // 2 
            ele = nums[mid] - nums[0]
            if (ele- mid) < k:
                low = mid
            else:
                high = mid - 1

     
        return nums[0] + low + k 