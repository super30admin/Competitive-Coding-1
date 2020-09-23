def missingnum(arr):
  n = len(arr)
  total = (n+1)*(n+2)/2
  arr_sum = sum(arr)
  return total - arr_sum
  
  
  #tc --> o(n)
  #sc ---> o(1)
