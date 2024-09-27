"""
Find the Missing Number in a sorted array
Given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list.
One of the integers is missing in the list. Write an efficient code to find the missing integer. 

Time Complexity: O(logn)
Space Complexity: O(1)
"""

def missing_value(arr):
    """
    In this approach we will check the difference between the index and the corresponding value.
    we will find the difference greater than 1 using Binary search 
    """
    #edge cases
    if arr[0] != 1:
        return 1
    if arr[len(arr)-1] != len(arr) + 1:
        return len(arr) + 1
    low = 0
    high = len(arr)-1
    while high > low +1:
        mid = (low + high)// 2
        if (arr[low] - low) != (arr[mid] - mid):
            high = mid
        else:
            low = mid
    return (arr[low]+ arr[high]) //2
a = [1,2,3,4,5,7,8,9]
print(missing_value(a))

