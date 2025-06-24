# Time Complexity: O(log n)
# Space Complexity: O(1)




def missing_binary_search(arr):

    low =  0
    high = len(arr)-1
    
    while low<=high:
        mid = low + (high-low) //2 
        
        # normal condition to check which side is sorted
        # based on the sorted side, we check if the mid element matches its index + 1
        # if it does, we know the missing element is on the right side
        # if it doesn't, we know the missing element is on the left side
        if arr[mid] == mid+1:
            low = mid+1
        else:
            high = mid-1
            
    return low + 1  # The missing element is the next number after the last valid index found.

if __name__ == "__main__":
    arr = [1, 2, 4, 5, 6]
    print(f"Missing element in {arr} is {missing_binary_search(arr)}")
    
    arr = [1, 3, 4, 5, 6, 7, 8]
    print(f"Missing element in {arr} is {missing_binary_search(arr)}")
    
    arr = [2]
    print(f"Missing element in {arr} is {missing_binary_search(arr)}")
    
    arr = [2, 3, 4, 5, 6]
    print(f"Missing element in {arr} is {missing_binary_search(arr)}")
    
    # edge cases
    arr = [1, 2, 3, 4, 5]
    print(f"Missing element in {arr} is {missing_binary_search(arr)}")
    
    arr = [1, 2, 4]
    print(f"Missing element in {arr} is {missing_binary_search(arr)}")