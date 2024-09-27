Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.

Examples:

Input : arr[] = [1, 2, 3, 5, 6, 7, 8]



Output : 4





Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]



Output : 3

# Time Complexity=O(log n)
# Time Complexity=O(1)

def missing(a):
    s=0
    e=len(a)
    while s+1<e:
        m=(s+e)//2
        if a[m]-m != a[s]-s:
            e=m
        else:
            s=m
    return a[s]+1
arr = [1, 2, 4, 5, 6, 7, 8, 9]
c=missing(arr)


