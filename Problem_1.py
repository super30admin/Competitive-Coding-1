"""
Problem : 1

Time Complexity : O(logn)
Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

checking whether the number matches with the number of index it is stored in
if not then returning the number 1 less than that number as missing element
or else traversing the right part of the array as left part is sorted

"""


def findMissing(arr):
    #checking if array starts from 1
    if arr[0]!=1:
        return 1
# checking if the the end of the array satisfies the ap formula
# as the index start from 0, the number at index should be 1 plus the index
    elif arr[-1]==len(arr):
#         this means the array does not have any missing element as the last number in array satiesfies the ap formula

        return len(arr)+1
    l=0
    r=len(arr)-1
    
    while l<=r:
        mid=l+(r-l)//2
        if l==r:
            return arr[r]-1
        # number which should be at mid
        numAtMid=mid+1
        #comparing with actual number at mid
        if arr[mid]==numAtMid:
            l=mid+1
        else:
            r=mid-1
    return arr[-1]+1
            
        
        
        
    

arr=[2,3,4,5,6,7]
print(findMissing(arr))

"""
using arithmatic progression
a=first element
d=difference

nth element=a+(n-1)d
=1(n-1)1
=n
so value at (n-1)th index should be n
"""
