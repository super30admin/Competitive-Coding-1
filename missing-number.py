'''
Problem was given from GeeksforGeeks:
https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/
Given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list. One of the integers is missing in the list. Write an efficient code to find the missing integer. 
Time Complexity: O(log n)
Space Complexity: O(1)
'''

def findMissing(arr, size):
	left = 0
	right = size - 1
	while left <= right:
		mid = (left +right)//2
		if mid < size and arr[mid] == mid + 1:
			left = mid + 1
		else:
			right = mid - 1
	return left + 1

arr = [1, 2, 3, 4, 5, 6, 8]
size = len(arr)
print("The missing number is", findMissing(arr, size)) # 7