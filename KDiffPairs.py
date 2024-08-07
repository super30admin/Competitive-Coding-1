# Time Complexity : O(N) 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : I faced issue on how to not consider duplicate numbers in below problem.

class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
        nums.sort()
        count=0 
        i=0
        j=1
        print(nums)

        while i<len(nums) and j<len(nums):
            diff=nums[j]-nums[i]
            if i!=j and abs(diff)==k:
                count+=1
                while i<len(nums)-1 and nums[i]==nums[i+1]:
                    i=i+1
                i=i+1
                j=j+1
            elif diff<k:
                j=j+1
            else:
                i=i+1
        return count


# Approach:

# I solved using a two-pointer technique. We sort the array first. Then I initialize
# two pointers, i and j, to the start of the array. We calculate the difference between the
# elements at the two pointers. If the difference is equal to k, we increment the count and move
# both pointers. If the difference is less than k, we move the right pointer. If the difference
# is greater than k, we move the left pointer.

    

       