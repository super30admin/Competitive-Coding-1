#Time Complexity:O(Log n) 
#Space Complexity: O(1)
#interview Problem
#program to find
# the only missing element in sorted Array.
def findmissing(ar, N):
	l = 0
	r = N - 1
	while (l <= r):
		mid = (l + r) / 2
		mid= int (mid)

	# If this is the first element
	# which is not index + 1, then
	# missing element is mid+1
		if(ar[mid] != mid + 1 and
		ar[mid - 1] == mid):
			return (mid + 1)

	# if this is not the first
	# missing element search
	# in left side
		elif(ar[mid] != mid + 1):
			r = mid - 1

	# if it follows index+1
	# property then search
	# in right side
		else:
			l = mid + 1
	
	# if no element is missing
	return (-1)
	
def main():
	ar= [1, 2, 3, 4, 5, 7, 8]
	N = len(ar)
	res= findmissing(ar, N)
	print (res)
if __name__ == "__main__":
	main()


