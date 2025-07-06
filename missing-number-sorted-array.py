"""
https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/

Edge cases:
empty array
1 element array
first element is missing
last element is missing

Time Complexity: O(logn)
Space Complexity: O(1)
"""
def missingNumber(nums):
  n = len(nums)
  if n == 0:
    raise Exception("Empty array")
  
  if nums[0] != 1: # first element is missing
    return 1
  
  if nums[n-1] != n + 1: # last element is missing
    return (n + 1)
  
  low = 0
  high = len(nums) - 1
  
  while (high - low) > 1:
    mid = (high + low)//2
    
    if nums[mid] == mid + 1:
      low = mid
    else:
      high = mid
  return nums[low] + 1


arr = [1, 2, 3, 4, 6, 7, 8]
print(missingNumber(arr))