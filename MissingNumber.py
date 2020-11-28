# Find the Missing Number in a sorted array (https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/)
# Time complexity: O(logn); n = length of the array
# Space complexity: O(1)
# Approach: Binary Search 
# Check if arr[i] - i is equal to arr[mid] - mid. This tells us that if any element is missing in the subarray i to mid. If an element is missing it will 
# change the chonology of indices w.r.t to the elements and difference will not be eqaul  

def findNumber(self, arr):
	n = len(arr)
	low = 0
	high = n-1

	while low+1 < high:
		mid = low + (high-low) // 2

		if (arr[low]-low) != (arr[mid]-mid):
			high = mid
		else:
			low = mid
	return arr[mid] + 1