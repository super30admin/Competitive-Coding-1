# Time Complexity: O(log n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: NOT APPLICABLE
# Any problem you faced while coding this: YES. My initial approach was incorrect.


a = [1,2,3,4,6,7,8]

def missing_value(a):
    
    low = 0
    high = len(a) -1
    
    while low <= high:
        mid = (low + high) // 2
        target = mid + 1
        
        if a[mid] == target:
            low = mid + 1
        else:
            high = mid - 1
            
    return mid + 1