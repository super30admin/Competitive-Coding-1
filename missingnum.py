arr=[1,2,3,5,6]

s=0
e=len(arr)-1

while s<=e:
    m=s+(e-s)//2
    if arr[m+1] != arr[m]+1:
        print(arr[m]+1)
    if arr[m+1]<=arr[m]+1:
        s=m+1
    else:
        e=m-1
