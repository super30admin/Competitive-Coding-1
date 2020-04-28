#Time Complexity: O(nlogn)
#Space Complexity: O(1)
  '''
  Main idea: If Mid is not equal to it's index, it means that on it's left the gap occured.
  Else, the gap occured on it's right. Like this we reduce the search space, we know the gap
  will occur in the interval [low,mid]
  Once we came out of the loop, we know that the gap was from low to high
  (two left, now they are equal),so the index at mid is the number before the gap
  then mid+1 is the missing one.
  Returning low or high is the same thing because it's the step just before they become equal
  [low,high]=[target-1,target+1]--> low=target, high=target
  here high doesn't become mid-1, but just mid!!. We want to make sure that there are two
  '''
class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        if not nums:
            return 0
        nums.sort()

        low=0
        high=len(nums)
        while high>low:
            mid=low+(high-low)//2
            if nums[mid]!=mid:
                high=mid
            else:
                low=mid+1
        return low
