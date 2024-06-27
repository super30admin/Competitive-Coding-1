# To find the missing element in sorted array of consecutive values in given array
# Problem Link: https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/

# Time Complexity --> O(logn)
# Space Complexity --> O(1)

# Approach:
# BS --> Set low and high pointer, and calc mid; loop until low and high cross each other
# First do diff of val at mid and mid-index. If diff 1, missing lies in right half
    # do low = mid + 1
# otherwise
    # do high = mid - 1
# at the end just return low + 1 will be missing val
class Solution:
    def Find(self, nums):
        low = 0
        high = len(nums)-1
        while low <= high:
            mid = low + (high-low) //2
            if nums[mid] - mid == 1:
                low = mid + 1
            else:
                high = mid - 1
        return low + 1


obj = Solution()
arr = [1,2,3,4,6,7,8]
res = obj.Find(arr)
print(res)
