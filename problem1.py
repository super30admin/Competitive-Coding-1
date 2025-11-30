#Find Missing Number in a sorted array
# Provide an array of n-1 integers in the range of 1 to n with no duplicates in list,
# One of the integers is missing in the list. Write a code to find the missing integer.
def search(arr):
    l=0
    r=len(arr)-1
    # Trying to make the binary search stop when both and l are equal
    while l<r:
        m=l+(r-l)//2
        # If it is true then until that point, numbers are in correct position, must be on right side
        if arr[m] == m+1:
            l=m+1
        #must be on left side including middle
        else:
            r=m
    return l+1
        