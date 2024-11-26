def getMissingElement(arr):
  ## Check if there is a missing element 
  low = 0
  high = len(arr) - 1
  if arr[high] == arr[low] + len(arr) - 1:
    return -1
  else:
    count = 0
    while high-low>2:
      mid = low + (high-low)//2
      #print(high,low,mid)
      if arr[mid] - arr[low] ==  mid - low:
        low = mid 
      else:
        high = mid +1
      
      
  return mid + arr[0]



arr = [2,3,4,6,7,8]
print(getMissingElement(arr))
