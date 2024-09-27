#find missing number in sorted array
def search(arr, size):
    #conditions for missing 1 and n
    if arr[0]!=1:
        return 1
    if arr[size-1]!= size+1:
        return size+1
    low=0
    high=size-1
    while high>low+1:
        mid=low+(high-low)//2
        if (arr[mid]-arr[low]) != (mid-low):
            high=mid
        elif (arr[high]-arr[mid]) != (high-mid):
            low=mid
    return arr[low]+1

a=[1,3,4,5,6,7,8]
n=len(a)
miss=search(a,n)
print(miss)