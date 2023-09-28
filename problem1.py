# Time Complexity: O(log n)
# Space Complexity: O(1)

def missingNumber(nums):
    if len(nums) == 0:
        return 0
    left, right = 0, len(nums) - 1
    while left <= right:
        mid = left + (right - left)//2
        if nums[mid] == mid + 1:
            left = mid + 1
        else:
            if nums[mid - 1] == mid:
                return mid + 1
            else:
                right = mid - 1
    if nums[0] != 1:
        return 1
    return nums[-1] + 1
