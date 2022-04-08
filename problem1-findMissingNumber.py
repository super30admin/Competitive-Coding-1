
# Time Complexity : O(log(N))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
def findMissing(arr: list) -> int:
    if arr is None or len(arr) == 0:
        return None
    
    low = 0
    high = len(arr)-1

    while low <= high:
        mid = int(low + (high-low)/2)

        if arr[mid] != mid+1: # not in place
            if mid == 0 or arr[mid-1] == mid: # is arr[mid] the missing number?
                return arr[mid]-1
            else: # missing number in left side
                high = mid - 1
        else:
            low = mid + 1
    
    return None

            
