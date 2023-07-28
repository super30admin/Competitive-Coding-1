def find_missing_number(arr):
    low=0
    high=len(arr)-1
    while low<=high:
        mid=low+(high-low)//2
        if arr[mid]-mid==1:         #missing element is on the right
            low=mid+1
        else:                         #Missing element is on the left
            high=mid-1
    return low+1