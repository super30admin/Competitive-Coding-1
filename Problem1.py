def missingNumber(nums):
  n = len(nums)
  low = 0
  high = n-1
  if nums[0] != 1:
      return 1
  while low <= high:
      mid = low + (high-low)//2
      if nums[mid] != mid+1 and nums[mid-1] == mid:
          return mid + 1
      if nums[mid] != mid+1:
          high = mid-1
      else:
          low = mid+1

  return n+1

if __name__ == "__main__":
  arr = [1, 2, 4, 5, 6, 7, 8]
  print(missingNumber(arr))
