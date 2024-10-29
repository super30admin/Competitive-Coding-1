# The code defines a function to find the k-th missing number in a sorted array 'nums'.
# It utilizes binary search to efficiently locate the missing element by comparing the number of missing elements calculated up to the midpoint of the array.
# The approach involves:
#   - Initializing two pointers, 'start' and 'end', to represent the current range of indices being considered (from the start to the end of the array).
#   - Computing the number of missing elements up to the mid index in each iteration. This is calculated as (nums[mid] - nums[0] - mid), which represents the difference between the actual value at mid and the expected value at mid if no numbers were missing.
#   - Adjusting the 'start' and 'end' pointers based on whether the calculated number of missing elements is less than or equal to 'k'. If fewer numbers are missing than 'k' up to 'mid', the search space is narrowed to the right half by setting 'start' to mid+1; otherwise, it's narrowed to the left half.
#   - The loop continues until 'start' exceeds 'end', meaning the exact position where the k-th missing number should be located is between 'end' and 'start'.
#   - The k-th missing number is then calculated directly from the adjusted 'start' pointer and the initial element in the array, accounting for any discrepancies due to previous missing numbers.
# Time Complexity (TC):
#   - The function operates in O(log n) time complexity, where n is the number of elements in 'nums'. This efficiency is due to the binary search approach which divides the search space in half with each iteration.
# Space Complexity (SC):
#   - The space complexity is O(1) as the solution only uses a few additional variables for the pointers and mid calculations, and does not require any extra space proportional to the input size.


class Solution:
    def missingElement(self, nums: List[int], k: int) -> int:
        start = 0
        end = len(nums)-1 
        while start <= end:
            mid = (start+end)//2
            value = nums[mid]-nums[0]-mid
            if value < k:
                start = mid+1 
            else:
                end = mid-1
        return nums[0]+start+k-1