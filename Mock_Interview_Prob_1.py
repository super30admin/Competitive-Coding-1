#Time Complexity : O(logn)
#Space Complexity : O(1)

class Solution:

    def findMissingElement(self,nums:int):
        l, r = 0, len(nums) - 1
        while l <= r:
            mid = (l + r) // 2
            if nums[mid] - mid > 1:
                r = mid -1
            else:
                l = mid + 1
        return nums[l-1] + 1
solution = Solution()
nums = [1,2,3,4,6,7,8]
missingValue = solution.findMissingElement(nums)
print({missingValue})