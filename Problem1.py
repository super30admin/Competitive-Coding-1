def solution(arr):
  n= len(arr)-1
  low=0
  high =n
  check =0
  while low<=high:
      mid = low + (high-low)//2
      if arr[mid] -mid ==2:
          if mid ==low or (arr[mid-1]-(mid-1)==1):
              return mid+1
          high =mid-1
      else:
          low = mid+1
  return len(arr)+1
