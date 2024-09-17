# Time Complexity:- O(log(n))
# Space Complexity:- O(1)
# Approach:- Since the elements are sorted and in a specified range we can use binary search to figure out
# where the missing element is. Since the numbers begin from 1 all the elements should have value index+1
# using this idea if we check the mid element and the mid element in the array is greater than mid+1
# we should check for the missing element on the left side else on the right side.
def find_missing_element(arr,n):
    low=0
    hi=n-1
    while(low<hi):
        mid=(low+hi)>>1
        if arr[mid]>mid+1:
            hi=mid-1
        else:
            low=mid+1
    return low+1

l=[1,3,4,5,6]
n=len(l)
print(find_missing_element(l,n))
