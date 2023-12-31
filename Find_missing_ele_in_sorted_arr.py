# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Any problem you faced while coding this : No
# If the difference between element and its index if more than 1 or the first element in the array, it means the missing element is to the left of element otherwise right side

from typing import List
class Solution:
    def MissingElement (self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        if len(nums) == 1 or len(nums)==0 :
            return -1
        while (low<=high):
            mid = low + (high-low)//2
            if nums[mid]-mid == nums[0]: #Middle element is consistent and the missing element lies on the right side
                if nums[mid+1]-nums[mid]>nums[0]:
                    return nums[mid]+1
                else:
                    low = mid +1
            else: #Missing element at left side
                if nums[mid]-nums[mid-1]>nums[0]:
                    return nums[mid]-1
                else:
                    high = mid -1
        return -1
                
s =  Solution()
print(s.MissingElement([1,3]))

