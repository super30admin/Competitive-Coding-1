#Time Complexity : O(logn) where n is length of input array
#Space Complexity : O(1) no auxilary space is used
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def missingNumber(self, nums):
        left, right = 0, len(nums)-1
        while left <= right:
            mid = left + (right-left)//2
            #numbers on the left are all in the correct position so we look only on the right side
            if nums[mid] == mid:
                left = mid + 1
            #numbers on the right are all in the correct position so we look only on the left side
            else:
                right = mid - 1

        #smallest number which is in the incorrect position thus it's index is the missing number
        return left
