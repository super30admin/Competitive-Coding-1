#time complexity - O(logn)
#space complexity - O(1)

def find_missing_number(arr):
  l=len(arr)
  low=0
  high=l-1
  
  if arr[0]!=1:
    return 1
  
  while low<=high:
    mid=low+(high-low)//2
    if mid+1 != arr[mid]:
      high=mid-1
    else:
      low=mid+1
  return arr[high]+1