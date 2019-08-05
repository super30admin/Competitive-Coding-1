class FindMissingElement:
	def findVal(self, arr):
		low = 0
		high = len(arr) - 1
		if arr[low] != low + 1:
			# because if 1 is missing then arr[mid] - mid == arr[low] - low will be same and it will be equal to 2
			return low + 1
		while high - low > 1:
			mid = low + (high - low)//2
			if(arr[mid] - mid == arr[low] - low): # even == 1 will work
				low = mid
			else:
				high = mid
		return (arr[low] + arr[high])//2

if __name__ == "__main__":
	arr = [2, 3, 4, 5, 6, 7, 8]
	fme = FindMissingElement()
	print(fme.findVal(arr))