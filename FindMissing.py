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

l = [1,2,3,5,6,7,8,9]
print(findMissing(l))
l = [1,2,3,4,6]
print(findMissing(l))

