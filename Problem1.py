class Solution:
    def missingElement(self, nums, k) :

        missing = lambda idx: nums[idx] - nums[0] - idx

        length = len(nums)

        if k > missing(length - 1):
            return nums[-1] + k - missing(length - 1)

        left = 0
        right = length - 1

        while left != right:
            pivot = left + (right - left) // 2

            if missing(pivot) < k:
                left = pivot + 1
            else:
                right = pivot

        return nums[left - 1] + k - missing(left - 1)

sol=Solution()
a = [1,2,3,8,9,11]
print(sol.missingElement(a,2))
