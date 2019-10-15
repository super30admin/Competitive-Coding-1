#Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.

def getMissingNo(a): 
    l = 0 
    r = len(a)-1
    while(l<=r):
        mid=l+(r-l)//2

        if (a[mid] == (mid+1)):
            l=mid+1
        else:
            r=mid
    return r+1
