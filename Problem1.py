#Time-Complexity: O(logn)
#Space-Complexity: O(1)

class Solution:
    def FindMissingNumber(nums):
        lo=0
        hi=len(nums)-1

        if lo>hi:
            return "Empty Array!"
        if(nums[lo] != 1):
            return 1
        if(nums[lo]==lo+1 and nums[hi] == (hi+1)):
            return "No Missing Values!"

        while hi > lo + 1:
            mid = (lo + hi) // 2
            if (nums[lo] - lo) != (nums[mid] - mid):
                hi = mid
            elif (nums[hi] - hi) != (nums[mid] - mid):
                lo = mid
        return nums[lo] + 1    

    nums=[1,2,4,5,6]
    f=FindMissingNumber(nums)
    print(f)

