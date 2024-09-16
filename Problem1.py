# Time Complexity: O(log n)
# Space Complexity: O(1)
# Any difficulties: No
          
arr = [1,2,3,4,5,6,7,9]
left = 0
right = len(arr)-1
while left <= right:
    mid = left + (right - left) 
    // 2 //if this condition is true it means that there is no missing number on the left, the condition has been generalized to check any type of input which starts from any integer
    if mid + 1 == arr[mid]:
        left = mid + 1
    else:
        right = mid - 1
print(left+1) 
