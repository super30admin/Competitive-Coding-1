
# All test cases in leetcode passed

# Here we apply binary search. If we get mid index as odd position then we decrement it by 1. 
# This is because duplicates are in pairs of 2, So every unique number starts at even index. 
# Now we compare nums at mid and mid+1 index. If they are equal it means our search area is to the right. 
# If they are not equal it means our search area is to left i.e. one number's duplicate is missing hence we shift to left. 
# Time complexity - O(logn)
# Space complexity - O(1)

class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
       
        if len(nums)==1:
            return nums[0]

        l = 0
        h = len(nums)-1

        while l<h:

            mid = (l+h)//2

            #checking if mid index is odd
            if mid%2==1:
                mid = mid-1

            #Here to have our search space as left side of mid we keep move right pointer to mid
            if nums[mid]!=nums[mid+1]:
                h = mid
            else:
                # Here if missin number is to the right side of mid then we need to increment left pointer by 2 
                # so that mid number's duplicate is crossed.
                l = mid+2
        
        return nums[l]