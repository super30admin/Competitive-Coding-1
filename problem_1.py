'''
Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, 
One of the integers is missing in the list. Write a code to find the missing integer.

Examples:

Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
Output : 4

Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]
Output : 3
'''

# Runtime = O(logN)
# Space complexity = O(1)

def divide_conquer(array):
    left = 0
    right = len(array) - 1

    # Only one element is missing and 
    # the array is sorted. So we can use a 
    # divide and conquer approach. We will divide the 
    # array in two parts. The part where the difference 
    # between left and right index and the difference 
    # in the elements corresponding to those indices 
    # is not the same, then the missing element exists 
    # in that part of the array.
    while left <= right:
        mid = (left + right)//2
        if (mid - left) != (array[mid] - array[left]):
            if (mid-left) == 1 and array[mid] - array[left] == 2:
                return array[mid] - 1
            right = mid 
        
        elif (right-mid) != (array[mid]-array[right]):
            if (right-mid) == 1 and array[right] - array[mid] == 2:
                return array[mid]+1
            left = mid 

array = [1,3,4,5,6]
print(divide_conquer(array))