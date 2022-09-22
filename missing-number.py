# Time Complexity :O(log N) N is total numbers in the array
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def missingNumber(self, nums):
        start = 0
        end = len(nums) - 0
        
        
        while start < end:
            mid = (start + (end - start)) // 2
            
            if nums[mid] != mid + 1 and nums[mid-1] == mid:
                return mid + 1
            elif nums[mid] == mid:
                start = mid + 1
            else:
                end = mid - 1
                
                
        return -1
    
s = Solution()

print(s.missingNumber([1,2,3,5,6,7]))