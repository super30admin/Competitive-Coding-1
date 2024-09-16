"""
Question
Provide an array of n-1 integers in the range of 1 to n with no duplicates 
in list, One of the integers is missing in the list. 
Write a code to find the missing integer.
"""
"""
Name: Srinidhi Bhat
Space Complexity - O(1) - Only variables
Time Complexity - O(n) - Traversing through the array for getting max, and doing sum

Logic: Sum to n numbers - n(n+1)/2 subtract it with current array_sum
This works since there are no duplicates and numbers range from 1 to n.
"""
def findNumber(arr):
    max_num = max(arr)
    arr_sum = sum(arr)
    sum_to_n = max_num*(max_num+1)//2
    return sum_to_n - arr_sum

arr = [1, 2, 3, 5, 6, 7, 8]
print(findNumber(arr))