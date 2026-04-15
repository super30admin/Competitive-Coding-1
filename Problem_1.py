# Find Missing Number in a sorted array range from 1 to n.

def findMissing(nums):
    n = len(nums)
    low,high = 0, n-1
    while low <= high:
        mid = low + (high - low)//2
        curr = nums[mid]
        if curr == mid + 1:
            low = mid + 1
        else:
            high = mid - 1
    return low + 1

nums = [1,3,4,5,6,7,8]
nums = [2]
print(findMissing(nums))