"""

    Student : Shahreen Shahjahan Psyche

    Time Complexity : O(log N)

    Space Complexity : O(1) [Constant space Auxiliary memory has been used]

    My code ran successfully for the 10 test cases that I have generated.

"""

from typing import List

class Solution:
    def missing_number(self, nums : List[int]) -> int:

        # Edge case
        if nums is None and len(nums) == 0:
            return -1     
        start = 0
        end = len(nums) - 1

        # checking if the first value is missing
        if nums[start]!=1:
            return 1  
        while(start<=end): 
            mid = start + (end - start)//2

            # checking whether my current value's difference from previous is 
            # whether more than 1
            if (mid != 0 and nums[mid] - nums[mid-1]>1):
                return nums[mid]-1
            # checking against my index value. If the current value is equal to 
            # its own index value then the missing value might be on the right 
            # side.
            if mid+1 == nums[mid]:
                start = mid + 1
            else:
                end = mid - 1
        
        return -1

# Testing My Solution
nums = [i for i in range(1, 11)]
problem = Solution()
for i in nums:
    nums2 = nums.copy()
    nums2.remove(i)
    print(problem.missing_number(nums2))



