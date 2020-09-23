# Time Complexity: O(log n)
# Space Complexity: O(1)
# Any difficulties: No
          
arr = [1,2,3,4,5,6,7,9]
left = 0
right = len(arr)-1
while left <= right:
    mid = left + (right - left) // 2 
    if mid + 1 == arr[mid]:
        left = mid + 1
    else:
        right = mid - 1
print(left+1) 
