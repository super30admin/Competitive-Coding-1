"""
Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.

Examples:

Input : arr[] = [1, 2, 3, 5, 6, 7, 8]

Output : 4


Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]


Output : 3
"""

class Prob15:

    def missingInt(arr):
        low, high = 0, len(arr) - 1
        
        while low + 1  < high:
            mid = low + high // 2
            if arr[mid] == mid + 1:
                low = mid
            else:
                high = mid
        return arr[low] + 1 
    arr = [1, 2, 3, 5, 6, 7, 8]
    obj = missingInt(arr)
    print(obj)


