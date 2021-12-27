'''
Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.

Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
Output : 4
Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]
Output : 3
'''

def findMissingElement(arr):
	low = 0 
	high = len(arr)-1 
	mid = 0 
	while (high - low >= 2):
		mid = low + (high - low)//2
		low_idx_diff = arr[low] - low
		mid_idx_diff = arr[mid] - mid
		high_idx_diff = arr[high] - high
		if ( mid_idx_diff  != mid_idx_diff ):
			high = mid 
		elif mid_idx_diff  != high_idx_diff :
			low = mid 
	return ( arr[low] + arr[high] )//2

# SOLUTION 2 

arr = [1,3]
def findMissingNumbers(l , h):
  m = l + (h-l)//2
  # print(l, h , m)
  if l+1 == h or l== h:
    # print("ok")
    if arr[l] - l == 1:
      # print("ok")
      # print(arr[l]+1)
      ans = arr[l]+1
      print(ans)
      return ans
    elif arr[l] - 1 > 1:
      ans = arr[l]-1
      print(ans)
      return ans
  
  if arr[m] - m > 1:
    # print("ok")
    findMissingNumbers(l , m-1)
  elif arr[m] - m == 1:
    # print("ok")
    findMissingNumbers(m+1, h)
