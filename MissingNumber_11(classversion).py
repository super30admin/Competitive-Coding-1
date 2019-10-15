def missingNumber(nums):
    low = 0
    high = len(nums) - 1
    mid = 0
    while ((high - low) >= 2):
        mid = low + (high - low) // 2
        idxLowDiff = nums[low] - low
        # print("low", idxLowDiff, nums[low],low)
        idxMidDiff = nums[mid] - mid
        # print("mid", idxMidDiff, nums[mid],mid)
        idxHighDiff = nums[high] - high
        # print("high", idxHighDiff,nums[high],high)
        if idxLowDiff != idxMidDiff:
            high = mid
        elif idxHighDiff != idxMidDiff:
            low = mid
    return int((nums[high] + nums[low]) / 2)

s = missingNumber([4,5,7,8])
print(s)