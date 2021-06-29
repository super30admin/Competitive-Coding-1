class Solution:
    def answer(self, nums):
        if not nums:
            return -1
        
        if nums[0] != 1:
            return 1
        
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = low + (high-low)//2
            
            if nums[mid] - mid == 2:
                high = mid - 1
            else:
                low = mid + 1
        
        return nums[low] - 1


s = Solution()
print(s.answer([]))
print(s.answer([2,3,4,5]))
print(s.answer([1,2,4,5]))