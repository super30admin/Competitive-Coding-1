# Time Complexity: O(n^2)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: NOT APPLICABLE
# Any problem you faced while coding this: YES. My initial approach was incorrect.

def missing_value(a):
    
    if a == None and len(a) <= 1:
            return 0
        
    n = len(a)
    
    # The idea is to use two nested loops, where the outer one iterate from 1 to n, and inner one iterate for each of the array arr[] elements, if the value in outer loop in not found in array arr[], return the value, else iterate to the next value.
    # Iterate from 1 to n and check if the current number is present
    
    for i in range(1, n + 1):
        found = False
        for j in range(len(a)):
            if a[j] == i:
                found = True
                break
        # If the current number is not present
        if not found:
            return i
    return 0

if __name__ == "__main__":
    a = [1, 2, 3, 4, 6, 7, 8]
    print(missing_value(a))


# Approach 2
# T = O(n)
# S = O(1)
# The idea for this approach is to compare the index and element on that index of the sorted array.
# If the difference between the index and element on that index is greater than 1 then the missing element is index + 1.
# If the difference between the index and the element for all index is 1 then the missing element is n. 

def missingNumber(arr):
    
    n = len(arr)+1
    
    # checking the difference between 
    # index and element
    for i in range(n-1):
        
        # if difference between index and element 
        # is not 1
        if arr[i] != i + 1:
            return i + 1
            
    # If the diference between index and element on that index for all index is 1             
    return n

if __name__ == "__main__":
    arr = [1, 2, 3, 4, 6, 7, 8]
    print( missingNumber(arr))


# Approach 3 - Binary Search
# T = O(log n)
# S = O(n)

def missingNumber(arr):
    n = len(arr)
    
    # Checking if the missing value is at index 0 or last index
    if arr[0] != 1:
        return 1
    if arr[n - 1] != n + 1:
        return n + 1
        
    # Implementing binary search
    lo, hi = 0, n - 1
    while hi - lo > 1:
        mid = (lo + hi) // 2
        if arr[lo] - lo != arr[mid] - mid:
            hi = mid
        elif arr[hi] - hi != arr[mid] - mid:
            lo = mid
    return arr[lo] + 1

if __name__ == "__main__":
    arr = [1, 2, 3, 4, 6, 7, 8]
    print(missingNumber(arr))