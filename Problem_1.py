# Time Complexity O(Log n) Space Complexity O(1)

def findMissing(nums):
  left = 0
  right = len(nums) - 1

  while left <= right:
    mid = left + (right - left) // 2

    if nums[mid] == mid + 1:
      #Look in right
      left = mid + 1
    else:
      #Look in left
      right = mid - 1
  

  return left + 1
