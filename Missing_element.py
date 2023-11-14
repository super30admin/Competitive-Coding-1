# Missing element

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        nums.sort()
        if nums[0]==0 and nums[-1]!=len(nums):
            return len(nums)
        if nums[-1]==len(nums) and nums[0]!=0:
            return 0
        low=0
        high=len(nums)-1
        while low<=high:
            mid=(low+high)//2
            if nums[mid]-nums[mid-1]>1:
                return nums[mid]-1
            if (mid==high and nums[mid]-nums[mid-1]==1) or (nums[mid+1]-nums[mid]>1):
                return nums[mid]+1
            elif nums[mid]-nums[low]==mid-low:
                low=mid+1
            else:
                high=mid-1
        print(nums)
        return -1
