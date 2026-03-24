# Find missing number in a 

# Time Complexity : O(log n)
# Space Complexity : O(1)
# Any problem you faced while coding this : no

class Solution:
 
    def findMissing(self, nums):
        low, high = 0, len(nums) - 1

        while low <= high:
            mid = (low + high) // 2

            # exit condition
            if nums[mid] - nums[mid - 1] == 2:
                return nums[mid] - 1
         
            # decide which half to eliminate
            if (nums[mid] - nums[low]) > (mid - low): #element is missing in left part of the array
                high = mid - 1
            else: #element is missing in right part of the array
                low = mid + 1
            
        return -1

s = Solution()
result = s.findMissing([2,3,4,5,7,8])
result = s.findMissing([2,3,4,5,6,8])
result = s.findMissing([2,4,5,6,7,8])
result = s.findMissing([1,3])
print(result)