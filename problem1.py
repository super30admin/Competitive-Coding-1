#find missing number in sorted array
#time complexity = O(logn) where n is the size of the array given
#solution explained on youtube video
def search(ar,size):
    low = 0
    high= len(size)-1
    mid=0
    while(high-low>=2):
        mid = low+(high-low)/2
        midiff= ar[mid]-mid
        lowidx = ar[low]-low
        
        if(midiff!=lowidx):
            high = mid
        else:
            low = mid
    return(ar[low]+ar[high])/2