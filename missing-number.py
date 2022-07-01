"""
Runtime Complexity:
O(log n) - runtime for binary search takes O(log n). Because we split the mid and search in either the left half or right half instead of searching all the elements. This split takes place further until we endup a index less than the missing element. Finally we return low+1 which captures the missing element.
Space Complexity: O(1) -  no new data structure is used to compute the result.
"""


def search(arr, size):
   # Extreme cases
    low = 0
    high = len(arr)
    while(low<=high):
        mid = (low+(high-low)//2)
        if arr[mid] == mid+1:
            low = mid+1
        else:
            high = mid-1
    return low+1
 
 
# Driver Code
arr = [1, 2, 3, 4, 5, 6, 7, 8, 10]
n = len(arr)
 
print("Missing number:", search(arr, n))