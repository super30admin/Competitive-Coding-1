#Time complexity - O(log n) where n is the length of input array
#Space complexity - O(1)
#Approach - We need to search for missing value in the half where element and it's index has a difference of more than 1
# as the array is contigous integers starting from 1. 

#function to find the missing value in a sorted array
def findmissing(arr,n):
    if not arr:
        return -1
    l,r = 0,n-1
    while l<r:
        mid = l + (r-l)//2
        if (arr[mid]>mid+1):
            r = mid
        else:
            l = mid+1
    return -1 if l>=(n-1) else  (l+1)