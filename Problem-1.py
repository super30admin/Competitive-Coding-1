# Time Complexity : O(log(n)) where m is the no of rows and n is the no of columns
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

#Your code here along with comments explaining your approach
a=[1,2,3,4,5,6,8]

def fidnMissing(a):
    n=len(a)
    l=0
    r=n-1
    while l<=r:
        mid=l+(r-l)//2
        if mid+1==a[mid]:
            l=mid+1
        else:
            r=mid-1

    return a[r]+1

print(fidnMissing(a))