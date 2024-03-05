# Time Complexity : O(logn)
# Space Complexity : O(1)
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

from typing import List
class Solution:
    def search(Self, nums: List[int])->int:
        low = 0
        high = len(nums)-1

        while(low<=high):
            mid = low + (high-low)//2

            if(nums[mid]==mid+1):
                low = mid + 1
            else:
                high = mid - 1
        
        return low + 1
    
sc = Solution()
nums = [1,3,4,5,6,7,8]
print(sc.search(nums))