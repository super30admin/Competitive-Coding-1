#TC:O(log n)
#SC:O(1)

#ar = [1,3,4,5,6,7,8]
def findMissingNumber(ar)
	if len(ar)<=1:
		print(-1)
	lo, hi = 0, len(ar)-1

	while(lo<hi):
		mid = lo + (hi-lo)//2
		if ar[mid] == mid +1:
			lo = mid + 1   
		else:
			hi = mid -1
	return lo + 1

print(findMissingNumber([1,3,4,5,6,7,8]))