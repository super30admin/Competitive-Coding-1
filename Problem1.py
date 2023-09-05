# Time Complexity : O(log(n)) 
# Space Complexity : O(1) as we are storing only low, mid and high.
# Did this code successfully run on Leetcode : NA
# Any problem you faced while coding this : NA
def findMissingElementFromSortedArray(arr):
    low = 0
    high = len(arr)-1
    while(low<=high):
        mid = (low + high) // 2
        if arr[mid] == mid + 1:
            low = mid + 1
        else:
            high = mid - 1    
    return low + 1
print(findMissingElementFromSortedArray([1,3,4,5,6,7]))
print(findMissingElementFromSortedArray([1,2,3,4,5,6,7,8,10]))