'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

#-------------  
# Explanation:
#-------------
#Provide an array of n-1 integers in the range of 1 to n with no duplicates 
# in list, One of the integers is missing in the list. 
# Write a code to find the missing integer.

#-----------------
# Time Complexity: 
#-----------------
# O(log(N)) - Iteratively reduce search space by half at every step
#------------------
# Space Complexity: 
#------------------
# O(1) - Constant space to store indices and values


input_arr = [1,2,3,5]


def find_missing(arr):
    low = 0
    high = len(arr) - 1

    while low <= high:
        
        mid = low + (high-low)//2

        # If this happens, then a number is missing on the LHS
        if arr[mid] > mid + 1:
            high = mid - 1

        # Else missing number on RHS
        else:
            low = mid + 1

    return arr[high] + 1

print(find_missing(input_arr))