# To find missing number in array starting from 1 to n (e.g. [1, 2, 3, ... n])
# for [1, 2] -> the missing number should be returned as 3 (at the very end)
# for [1, 2, 3, 4, 6, 7, 8, 9] -> the missing number shall be 5

def SearchMissing(arr):
    
    '''
    Use BST to optimize the time complexicity from O(n) in brute force approach to 
    O(log(n)) using Binary search tree (drop half elements in each step)
    '''
    
    #initialize the left and right indices
    l = 0; r = len(arr) - 1
    
    # until left and right matched keep dividing and updating the indices based on side with missing number
    while r > l:
        m = l+ (r-l)//2
        if arr[m] != m + 1:
            r = m - 1
        else:
            l = m + 1
            
    return m + 1 if len(arr) != arr[r] else len(arr)+1