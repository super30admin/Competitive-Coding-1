# Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, 
# One of the integers is missing in the list. Write a code to find the missing integer.

def missing_int(array):
    low=0
    high=len(array)-1
    while(low+1<high):
        mid = (low+high)//2
        if((array[high]-array[mid]) > (high-mid)):
            low=mid
        else:
            high=mid
    return array[high]-1

#test

print(missing_int([1, 2, 3, 5, 6, 7, 8]))
print(missing_int([1, 2, 4, 5, 6, 7, 8, 9]))
array = [1, 3, 4, 5, 6, 7]
print(missing_int(array))