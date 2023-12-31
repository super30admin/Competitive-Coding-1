# Find the missing element in a sorted array

# Time-Complexity : O(log n)
# Space Complexity : O(1)

def getMissingElement(nums):
    low = 0
    high = len(nums) - 1

    while (high - low) > 1:
        mid = low + (high - low) // 2

        if nums[mid] - mid == nums[low] - low and nums[mid] - mid != nums[high] - high:
            low = mid
        else:
            high = mid

    return nums[low] + 1


nums = [11, 12, 13, 15, 16]
s = getMissingElement(nums)
print("result")
print(s)
