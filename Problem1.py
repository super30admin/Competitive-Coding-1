def findMissing(nums):
  low = 0 
  high = len(nums)-1

  while (high - low) > 1:
    mid = low + (high - low)//2
    mididx = nums[mid]-1
    highidx = nums[high]-1
    lowidx = nums[low]-1

    if (mididx != highidx):
      low = mid
    else:
      high = mid
  return (nums[low]+nums[high])//2

nums = [1,3]

findMissing(nums)

# this is a more efficient solution which works even with 2 elements.
#TS is O(log(n)) for binary search
#SC is O(1)