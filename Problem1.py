# Time Complexity: O(N)
# Space Complexity: O(1)

# I cam up with brute force and then I was seraching for the most optimal solution in Time as well as space complexity.
#The length of the array is n-1. So the sum of all n elements, i.e sum of numbers from 1 to n can be calculated using the formula n*(n+1)/2. Now find the sum of all the elements in the array and subtract it from the sum of first n natural numbers, it will be the value of the missing element.
def getMissingNo(arr):
	n = len(arr)
	total = (n + 1)*(n + 2)/2
	sum_of_arr = sum(arr)
	return total - sum_of_arr

arr = [1, 2, 4, 5, 6]
miss = getMissingNo(arr)
print(miss)


