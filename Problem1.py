# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# using sum of n numbers and substracting the sum of the given numbers to get the missing one
class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        return self.binary(nums,0,len(nums)-1)
        
    def binary(self,arr,l,r):
        if l > r:
            return arr[l]-1
        mid = (l+r)//2
        if arr[mid] != mid+1:
            return self.binary(arr,0,mid-1)
        return self.binary(arr,mid+1,r)
