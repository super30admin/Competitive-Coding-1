
def findMissingNum(arr):
    low = 0 
    high = len(arr) - 1             
    while low + 1 < high:
        mid = (low + high) >> 1
        
        if arr[low] - low != arr[mid] - mid:
            high = mid 
        elif arr[mid] - mid != arr[high] != high:
            low = mid 
    return (arr[low] + 1)
  
  
a = [1,2,4,5,6,7,8]
print(findMissingNum(a))
