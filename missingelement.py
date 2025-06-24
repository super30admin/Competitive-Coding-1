#Time Complexity: O(logn)
#Space Complexity: O(1)

class Solution:
    def missingelement(self,nums):
        low=0
        high=len(nums)-1

        while low<=high:
            mid=low+((low-high)//2)
            if nums[mid]==mid+1:
                low=mid+1
            else:
                high=mid-1

        return low+1


