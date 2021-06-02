# Time Complexity : O(logn)
# Space Complexity : O(1)
# Any problem you faced while coding this : NO

# Your code here along with comments explaining your approach

# Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
# Output : 4
# Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]
# Output : 3

def missing_num(arr, n):
    low = 0
    high = n
    while high-low >=2:
        mid = low + (high-low)//2
        if arr[mid]-mid != 1:
            high = mid
        else:
            low = mid
    return (arr[low] + arr[high])//2


arr = [1,2,3,4,5,7]
n = len(arr)
print(missing_num(arr,n))
