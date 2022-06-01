""""// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
#
def search(arr):
    l=0
    r=len(arr)-1
    while r-l>1:
        mid=l+(r-l)//2
        if (mid-l)<(arr[mid]-arr[l]):
            r=mid-1
        else:
            l=mid+1
    return (arr[l]+arr[r])//2

print(search([3,4,5,7]))

















