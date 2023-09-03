

def missingval():
    a=[1,2,4,5,6,7,8]
    lo,hi=0,len(a)-1
    while lo<=hi:
        mid=lo+(hi-lo)//2
        if a[mid]>mid+1:
            hi=mid-1
        else:
            lo=mid+1
    return a[hi]+1

print(missingval())    
