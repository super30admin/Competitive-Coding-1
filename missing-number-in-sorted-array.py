#TC: O(logn)
#SC: O(1)
class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        nums.sort()
        n=len(nums)
        if nums[-1]-nums[0] == n-1:
            return 0 if nums[0]!=0 else n
        l,r=0,n-1
        while(l<r-1):
            mid=l+(r-l)//2
            if mid-l==nums[mid]-nums[l]: l=mid
            else: r=mid
        return nums[l]+1