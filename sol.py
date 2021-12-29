#Time Complexity O(Log n)
#Time Complexity O(1) constant time

a = [1,2,3,4,6,7]

low = 0
high = len(a)-1

while low<=high:
  mid = (low + (high-low)) //2
  
  if a[mid]==mid+1:
    high = mid-1
  else:
    low = mid +1
print(low +1)
