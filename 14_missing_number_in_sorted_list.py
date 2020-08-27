#Time Complexity : O(NlogN) N is the numbers present in the list
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : 

#Your code here along with comments explaining your approach

def missing(arr):
    start=0
    end=len(arr)-1
    while start<=end:
        mid=(start+end)//2
        if arr[mid]!=mid+1 and arr[mid-1]==mid:
            return mid+1
        elif arr[mid]==mid+1:
            start=mid+1
        elif arr[mid]!=mid+1:
            end=mid-1