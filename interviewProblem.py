def findMissingNumber(self, nums:List[int]) -> int:
    if nums[0] !== 1:
        return 1
    low, high = 0, len(nums)-1
    while low <= high:
        mid = (low+high)//2
        if nums[low]-low !== nums[mid]-mid:
            high = mid
        else:
            low = mid + 1
    return mid + 1