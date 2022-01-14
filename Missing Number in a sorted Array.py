# Time Complexity : O(logN)
#  Space Complexity :O(1)
def Search(arr, size):
    low =0
    high = size -1
    mid = 0
    while(high-low>=2):
        mid = low + (high-low)//2
        lowDiff = arr[low]-low
        highDiff = arr[high] -high
        midDiff = arr[mid] - mid
        if(lowDiff!= highDiff):
            high = mid
        elif(highDiff!=midDiff):
            low = mid
    return (arr[high]+arr[low])/2
