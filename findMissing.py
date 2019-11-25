# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No problem

class Solution(object):
    def __correctNumber(self, nums, l, m):
        return nums[l] + m - l

    def missingNumber(self, nums):
        l, h = 0, len(nums) - 1
        while l <= h:
            m = l + (h - l) // 2
            if nums[m] - nums[m -1] != 1:
                return nums[m] - 1
            elif nums[m] == self.__correctNumber(nums, l, m):
                l = m + 1
            else:
                h = m - 1


obj = Solution()
nums1 = [0,2,3,4]
ans1 = 1
nums2 = [0,1,2,4]
ans2 = 3
nums3 = [4,5,6,7,8,9,11]
ans3 = 10
nums4 = [1,2,4,5,6]
ans4 = 3

nums = [nums1, nums2, nums3, nums4]
anss = [ans1, ans2, ans3, ans4]
for i, num in enumerate(nums):
    ans = obj.missingNumber(num)
    print(ans)
    print(ans == anss[i])

