'''
First find the mid and check whether difference between index mid and element at mid
is greater than 1. If greater than 1, move the right pointer else move the left pointer
When loop ends, return left+1. 
'''
# Time Complexity: O(log n)
# Space Complexity: O(1)

def findMissing(arr):
    left, right = 0, len(arr)-1
    
    while left<=right:
        mid = (left+right)//2
        
        if(arr[mid] - mid > 1):
            right = mid -1
        else:
            left = mid + 1
    return left + 1

print(findMissing([1,2,4,5,6,7]))
print(findMissing([1,2,3,4,5,6,7]))
print(findMissing([1,2,3,5,6,7,8]))