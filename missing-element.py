# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Asked in mock interview


# Your code here along with comments explaining your approach

def findMissing(arr):
    low = 0
    high = len(arr) - 1
    while low + 1 < high:
        mid = low + (high - low) // 2
        if arr[mid] - mid == 1:
            low = mid
        else:
            high = mid
    
    return arr[low] + 1

arr =[1,2,4,5,6,7,8]
print findMissing(arr)