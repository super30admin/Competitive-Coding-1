class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        left = 0
        right = len(nums) - 1
        
        while left <= right:
            mid = (left + right)//2
            
            if ((mid == left or nums[mid]>nums[mid-1]) and (mid == right or nums[mid]>nums[mid+1])):
                return mid
            elif (nums[mid+1] > nums[mid]):
                left = mid + 1
            else:
                right = mid - 1
        return -1
    
    # Time complexity: O(log(n))
    # Space Complexity: O(1)
