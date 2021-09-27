# Time complexity : O(logn)
# Space complexity : O(1)
# Interesting thing to note is the position of mid and low pointers when the while loop terminates. Thats the main hint for this solution
class Solution:
    def missingElement(self, nums):
        if len(nums) == 0:
            return -1
        low, high = 0, len(nums)-1
        while low <= high:
            mid = (low+high)//2

            if nums[mid]-mid == 1:
                low = mid+1
            else:
                high = mid-1
        return low+1


solution = Solution()
print(solution.missingElement([1, 2, 3, 4, 6, 7, 8]))
print(solution.missingElement([1, 2, 3, 4, 5, 6, 8, 9]))
