def search(arr):
    low = 0; high=len(arr)-1

    if arr is None or len(arr)==0:
        return -1

    while low<=high:
        mid = (low+high)//2
        #print(mid)
        if arr[mid] == mid+1:
            low=mid+1
        elif mid==0 or mid==len(arr)-1:
            #print("yes")
            return arr[mid]-1
        else:
            high=mid

    return -1


arr=[1,2,3,5]
x=search(arr)
print(x)
