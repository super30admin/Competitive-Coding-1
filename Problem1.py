"""
TC: O(logN) {Used binary search to eliminate the search space by half, if the index + 1 == number at that index, we know the left part is sorted}
SC: O(1) {No extra space is used here}

Approach:

We use two pointers for our Binary search and reduce the search space by half if we dont find any discrepancy, i.e. if the index + 1 matches the number at that index.

The problem ran successfully on GeeksForGeeks
"""
def missingNumber(arr):
    n = len(arr)

    left, right = 0, n - 1
    
    while left < right:
      mid = left + (right - left)//2
      
      if arr[mid] == mid + 1:
        left = mid + 1
      elif arr[mid] > mid + 1:
        right = mid 
    return left + 1

if __name__ == "__main__":
    arr = [1, 2, 3, 4, 5, 6, 8, 9]
    print(missingNumber(arr))