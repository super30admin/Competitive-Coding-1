"""
Time complexity: O(logn)
Space complexity: O(1)
"""
def findMissing(arr):
    l, h = 0, len(arr) -1
    while l <= h:
        m = (l+h)//2
        if arr[m]>m+1:
            h = m-1
        else:
            l = m+1
    return h+2


arr = [1,2,3,4,6,7,8]
print(findMissing(arr))

arr = [2,3,4,6,7,8]
print(findMissing(arr))

arr = [1,2,3,4,5,6,7]
print(findMissing(arr))