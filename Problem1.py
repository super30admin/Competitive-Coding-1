#Find missing number in contiguous array.
#Time Complexity-O(logn)
#Space Complexity-O(1)
def search(ar, size): 
    low=0
    high=size-1
    while (low <= high):
        mid = low + (high - low) // 2
        if (mid + 1 < ar[mid]):
            high = mid - 1;
        elif (mid + 1 == ar[mid]):
            low=mid+1
    return low + 1
  

a = [1, 2, 3, 4, 5, 7] 
n = len(a) 
missing=search(a, n)
print(missing)
