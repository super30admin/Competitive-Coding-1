def binarysearch(arr):
    l = 0
    h = len(arr)-1
    while(l<=h):
        mid = int((h + l)/2)
        if((mid-1<0 or arr[mid-1]-(mid-1)==1) and arr[mid]-mid>1):
            return mid+1
        elif(arr[mid]-mid>1):
            h = mid
        else:
            l = mid+1
    return l+1
print(binarysearch([1,2,3]))