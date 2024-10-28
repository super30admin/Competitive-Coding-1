def findMissing(nums):
    n = len(nums)
    low = 0
    high = n-1

    if nums[0] != 1:
        return 1
    if nums[n-1] != n+1:
        return n+1

    while low <= high:
        mid = (low + high) // 2
        if mid == len(nums) - 1 or nums[mid] != nums[mid+1] - 1:
            return nums[mid] + 1
        if high - mid != nums[high] - nums[mid]:
            low = mid
        else:
            high = mid


print(findMissing([1, 2, 3, 4,5, 6, 7, 8, 9,11 ]))
