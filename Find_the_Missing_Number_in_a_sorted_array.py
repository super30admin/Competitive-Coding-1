def findMissingNumber(arr):
    low, high = 0, len(arr)-1
    
    ### Binary Search
    while low <= high:
        mid = low + (high-low)//2
        if arr[mid] == mid+1:
            low = mid+1
        else:
            high = mid-1
    return low+1

# Driver Code 
test_1 = [1, 2, 3, 4, 5, 6, 8] 
test_2 = [2, 3, 4, 5, 6, 7] 
test_3 = [1, 2, 3, 5, 6, 7] 
print("Missing number:", findMissingNumber(test_3)) 

### Complexity Analysis ###
# Time Complexity: O(logN) --> Binary Search
# Space Complexity: O(1)