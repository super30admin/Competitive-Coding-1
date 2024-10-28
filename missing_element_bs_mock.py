def search(arr):
    l,r = 0, len(arr)-1
    while l<=r:
        mid = l+(r-l)//2
       if arr[mid]== mid+1:
           l= mid+1
       else:
            r = mid-1
    return l+1
