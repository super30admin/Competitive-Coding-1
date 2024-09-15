#time comp- O(logn) used binary search
#space comp - O(1) no extra space used
def missingNumber(a):
  l=0
  h=len(a)-1
  while l<h:
    mid=l+(h-l)//2
    if a[mid]==mid+1:
      l=mid+1
    else:
      h=mid
  return l+1
a=[1,2,3,4,5,6,7]
missingNumber(a)
