"""

Given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list. 
One of the integers is missing in the list. Write an efficient code to find the missing integer. 

Examples: 

Input : arr[] = [1, 2, 3, 4, 6, 7, 8]
Output : 5

Input : arr[] = [1, 2, 3, 4, 5, 6, 8, 9]
Output : 7

Time Complexity: O(n) for hashing, O(log n) for binary search  
Space Complexity: O(n) for hashing, O(1) for binary search  

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Approach:  
# 1. The first approach uses hashing to check for the missing number in O(n) time and space.  
# 2. The second approach uses binary search to efficiently find the missing number in a sorted array in O(log n) time and O(1) space.  
# 3. The binary search method compares expected and actual indices to narrow down the missing number's location.  


def find_missing_number(arr):

    # method 1:
    # Time Complexity: O(n)  
    # Space Complexity: O(n)  
  
    n = len(arr) + 1
    hash_set = set(arr)

    for i in range(1, n):
        if i not in hash_set:
            return i

    return n  # If no number is missing in the range

  
    # method 2:
    # Time Complexity: O(log n)  
    # Space Complexity: O(1)  
  
    n = len(arr)

    if arr[0] != 1:
        return 1  
    elif arr[n-1] != n+1:
        return n+1  

    left, right = 0, n-1  

    while left + 1 < right:
        mid = left + ((right-left) // 2)
        if arr[left] - left != arr[mid] - mid:
            right = mid  
        elif arr[right] - right != arr[mid] - mid:
            left = mid  

    return arr[left] + 1  
