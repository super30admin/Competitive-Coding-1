#time complexity = O(logN) where n is number in the element
#Auxiliary Space: O(1)

def find_missing_number(arr, size):
    if arr[0] != 1:
        return 1
    
    if arr[size-1] != size+1:
        return size+1
    
    low =0
    high = len(arr)-1
    mid=0

    while high -low >=2:
        mid = low + (high - low)//2

        midIdx = arr[mid] - mid
        lowIdx = arr[low] - low
        highIdx = arr[high] -high

        if midIdx != lowIdx:
            high = mid
        elif midIdx != highIdx:
            low = mid
        
    return (arr[low]+arr[high])//2

arr1 = [1,2,4,5,6,7,8,9]
n = len(arr1)

print("missing number is :",find_missing_number(arr1,n))