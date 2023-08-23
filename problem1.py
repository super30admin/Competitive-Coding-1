class Missing:
    
    def missingInt(arr):
        low, high = 0, len(arr) - 1

        while low + 1  < high:
            mid = low + high // 2
            if arr[mid] == mid + 1:
                low = mid
            else:
                high = mid
        return arr[low] + 1 
    arr = [1, 2, 4, 5, 6, 7, 8]
    obj = missingInt(arr)
    print(obj)
