#find missing element 
#
def search(arr):
    if arr[0]!=1: #edgecase-1
        return 1
    if(len(arr)-1 !=len(arr)+1): #edgecase-2
        return len(arr)+1
    
    low = 0
    high = len(arr)-1
    mid = 0
    while (high-low>=2):
        mid = low+(high-low)//2
        midiff= arr[mid]-mid
        lowdiff = arr[low]-low
        if midiff!=lowdiff:
            high =mid
        else:
            low = mid
    return (arr[low]+arr[high])//2
