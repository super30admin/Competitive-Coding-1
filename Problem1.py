# Problem 1: Find the missing number in an array of consecutive numbers

# Time Complexity: O(logn)
# Space Complexity: O(1)

# Approach: Binary Search
# Use binary search to efficiently find the missing number in a sorted array.
# Adjust the low and high pointers based on the difference between the middle element and its index.
# The final position of the low pointer indicates the missing number's index, so return low + 1.

# Example:
# Input: [1, 2, 3, 4, 5, 6, 8]
# Output: 7

def findMissingNumber(nums):
	low, high = 0, len(nums)-1

	while low<=high:
		mid = low + (high-low)//2
		if nums[mid] - mid != 1:
			high = mid - 1
		else:
			low = mid + 1
	return low + 1

assert findMissingNumber([1, 2, 3, 4, 5, 6, 8]) == 7
assert findMissingNumber([1, 2, 3, 4, 5, 6, 7, 8, 10]) == 9
assert findMissingNumber([2]) == 1
