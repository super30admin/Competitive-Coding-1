# Time Complexity: O(log n)
# Space Complexity: O(1)

def MissingElement(arr, n):
    low = 0
    high = n - 1
    while (low <= high): 
        mid = low + (high-low) // 2

        if(arr[mid] != mid + 1 and
           arr[mid - 1] == mid):
            return (mid + 1)

        elif(arr[mid] != mid + 1):
            high = mid - 1
            
        else:
            low = mid + 1
    
    return -1
    