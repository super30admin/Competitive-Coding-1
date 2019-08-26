"""
check for this condition at every mid postion
if the condtion is true then the left part of
the array is fine and no missing element is
there and missing element is towards the right  
side if false missing it means missing elements
are there in the left side. continue this until
you reach a point where low+1< high is false and there
your arr[low] + 1 will be the missing element.
"""

def FindElement(arr):
    low = 0
    high = len(arr)-1
    while low+1<high:
        mid = low + (high-low) //2
        if arr[mid] == mid+1: 
            low = mid 
        else:
            high = mid
    return arr[low] + 1

arr = [1,2,4,5,7,8,9,10,11,12,13,14,15,16]
print(FindElement(arr))

