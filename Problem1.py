# Time Complexity: O(log n): binary search halves the search window each iteration
# Space Complexity: O(1): only a fixed number of variables used, no extra data structures
# In a perfect sequence, every element minus its index equals 1
# When a number is missing, this difference shifts from 1 to 2 at the missing number's position
# Binary search finds the exact boundary where this shift occurs

def missingNumber(arr):
    n = len(arr)                            # n = actual number of elements in array 
    
    # Extreme cases
    if arr[0] != 1:                         # if first element is not 1, then 1 itself is missing
        return 1                            # return 1 immediately without searching
    if arr[n - 1] != n + 1:                 # if last element is not n+1, the missing number is at the end
        return n + 1                        # return n+1 immediately without searching
        
    # Implementing binary search
    lo, hi = 0, n - 1                        # lo and hi are index positions, starting at first and last index
    while hi - lo > 1:                       # keep looping until lo and hi are adjacent (next to each other)
        mid = (lo + hi) // 2                 # find the middle index using integer division
        if arr[lo] - lo != arr[mid] - mid:   # if difference shifts between lo and mid, boundary is in left half
            hi = mid                         # shrink right boundary to mid 
        elif arr[hi] - hi != arr[mid] - mid: # if difference shifts between mid and hi, boundary is in right half
            lo = mid                         # shrink left boundary to mid 
    return arr[lo] + 1                       # lo is last index with difference 1, so missing number is arr[lo] + 1

if __name__ == "__main__":
    arr = [1, 2, 3, 4, 6, 7, 8]       
    print(missingNumber(arr))           