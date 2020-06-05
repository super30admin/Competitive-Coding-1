def search(array): 
	low = 0
	high = len(array) -1
	mid = 0
	while low+1< high:
		mid = (low + high)//2
		if (array[low] - low) != (array[mid] - mid): 
			high = mid 
		elif (array[high] - high) != (array[mid] - mid): 
			low = mid 
	return array[mid]+1

arr = [1,2,3,4,5,6,7,8,9,10,11,12,14,15,16]
print(search(arr))