arr=[ 2, 3, 4, 5, 6, 7, 8]
low=0
high=len(arr)-1
while(low<=high):
    mid=low+(high-low)//2
    if(arr[mid]==mid+1):
    	low=mid+1
    else:
    	high=mid-1
if(mid==len(arr)-1 and arr[mid]==mid+1):
    print("No Number Missing")
else:
    print(mid+1)