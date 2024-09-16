# Approach:
# Brute Force: Iterate over the array and at every iteration increment the value by 1 and check if the next number is equal to this value
# This means the numbers would be in order and nothing is missing
# Time Complexity: O(N) -- Worst Case the missing number could be at the end of the array
# Space Complexity: O(1) -- NO aux space used

# Optimized Solution: O(log(N)) Time & O(1) Space
# If the very first number is not 1 we could return this as the missing number since numbers in array are from 1 - n
# We could apply binary search to eliminate half of the search space everytime.
# Check if the middle value  == middle + 1 ---> This means the middle number corresponds to the index it should be at
    # If value at middle != its index value and previous element is at its correct index postion 
    #  Then return the middle + 1 as the missing number
    # The missing number will be on its right


def findMissingNumber(array):
    
    left = 0
    right = len(array) - 1
    
    if array[0] != 1:
        return 1
    
    while left <= right:
        
        middle = left + (right - left) // 2
        
        if array[middle] != middle + 1 and array[middle - 1] == middle:
            return middle + 1
        
        elif array[middle] == middle + 1:
            left = middle + 1
            
            
        else:
            right = middle - 1
            
            
    return False