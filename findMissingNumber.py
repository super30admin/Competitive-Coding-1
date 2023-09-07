class Solution:
    def missingNumber():
        nums = [1,2,3,4,6,7,8]
        left = 0
        right = len(nums)-1
        mid  = 0 

        while (left+1 < right):
            mid = (left+right) // 2

            if mid + 1 == nums[mid]:
                left = mid
            else:
                right = mid

        return mid +1
    
# TC: O(log(n))
# SC: O(1)