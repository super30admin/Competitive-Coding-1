# Find the missing number from the sorted array 
# Time Complexity = O(logN)
# Space complexity = O(1)
def find_miss(arr):
    if len(arr) == 0: # empty array
        return None
    if len(arr) == 1: # unit length array
        return arr[0] - 1 if arr[0] > 1 else None
    if arr[0] > 1: # checks if the starting element suggests a missing number before it
        return arr[0] - 1
    
    low, high = 0, len(arr) - 1
    while low <= high:
        mid = low + (high - low) // 2
        if mid > 0 and arr[mid] - arr[mid - 1] == 2: # to avoid index out of bound at first element
            return arr[mid] - 1
        if arr[mid] - arr[0] != mid:
            high = mid - 1
        else:
            low = mid + 1
    # check if the array is complete 
    if arr[-1] - arr[0] == len(arr) - 1:
        return arr[-1] + 1

print(find_miss(arr))