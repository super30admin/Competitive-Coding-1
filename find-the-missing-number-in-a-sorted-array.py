def findMissingElement(nums):
    n = len(nums)
    low = 0
    high = n - 1
    while low <= high:
        mid = low + (high - low) // 2
        if nums[mid] == mid + 1:
            low = mid + 1
        else:
            high = mid - 1
    return low + 1

nums = [1,2,3,4,6]
print(findMissingElement(nums))
nums = [1,3,4,5,6]
print(findMissingElement(nums))
nums = [2,3,4]
print(findMissingElement(nums))
nums = [1,3]
print(findMissingElement(nums))
