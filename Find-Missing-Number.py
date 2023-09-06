# Time Complexity : O(log(n)) 
# Space Complexity : O(1)

def findMissingElementFromSortedArray(arr):
    low = 0
    high = len(arr)-1
    while(low<=high):
        mid = (low + high) // 2
        if arr[mid] == mid + 1:
            low = mid + 1
        else:
            high = mid - 1    
    return low + 1
print(findMissingElementFromSortedArray([1,3,4,5,6,7]))
print(findMissingElementFromSortedArray([1,2,3,4,5,6,7,8,10]))