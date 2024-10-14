#  Time Complexity : O(logn)
#  Space Complexity :0(1)

class Solution(object):
    def findMissingNumber(self, nums):
        # Input: arr[] = [1, 2, 3, 4, 5, 6, 8]
        # Output: 5
        n = len(nums)
        low, high = 0, n - 1
        while low <= high:
            mid = low + (high - low) // 2
            # print(f'low {low} high {high} mid {mid}')
            if nums[mid] <= mid + 1:
                low = mid + 1
            else:
                high = mid - 1
        return (low + nums[low]) // 2


sol = Solution()
# nums = [1, 2, 4, 5,6,7, 8]
nums = [1, 2, 3, 4, 5, 6, 8, 9]
print(sol.findMissingNumber(nums))
