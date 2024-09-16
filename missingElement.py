class missing:
    
    def search(arr: list[int], n: int):
        if len(arr) == 0:
            return -1
        
        low = 0
        high = len(arr) - 1
        
        while (low <= high):
            mid = low + ((high - low) // 2)
            
            # Checking difference between the element and its correponding index. 
            # Difference should be constant for a continuous array. If its not, that means an               element is missing
            if (arr[low] - low) == (arr[mid] - mid):        # Move right
                low = mid + 1
            else:                                           # Move left
                high = mid - 1
            
            # Conditions to handle the boundary conditions
            if high - low == 1:
                return (arr[low] + arr[high]) // 2
            if arr[mid - 1] - (mid - 1) != arr[mid] - mid:
                return (arr[mid - 1] + arr[mid]) // 2
            elif arr[mid + 1] - (mid + 1) != arr[mid] - mid:
                return (arr[mid + 1] + arr[mid]) // 2