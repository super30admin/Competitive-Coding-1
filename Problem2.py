#time complexity : O(logn)
#Space complexity: O(1)
def find_element(arr):
    low = 0
    high = len(arr) - 1
    while low + 1 < high:
        mid = low + (high - low) // 2
        
        middiff = arr[mid] - mid
        lowdiff = arr[low] - low
        highdiff = arr[high] - high
        
        if middiff != lowdiff:
            high = mid
        elif middiff != highdiff:
            low = mid
            
    return arr[low] + 1
    

arr = [1,3,4,5,7]
var = find_element(arr)
print(var)