def binary_search(l):
    low=0
    high=len(l)-1
    while low<=high:
        mid=low+(high-low)//2
    if low==high:
        return low+1
    if l[mid]==mid+1:
        low=mid+1
    else:
        high=mid-1