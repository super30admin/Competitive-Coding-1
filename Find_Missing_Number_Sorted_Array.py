def find_missing(nums):

    low = 0
    high = len(nums) -1
    if not nums:
        return
    while low <= high:
        mid = low + (high-low) // 2
        if nums[mid] == mid+2 and nums[mid-1] == mid:
            return mid+1
        elif nums[mid] == mid+2:
        #elif nums[mid] != mid+1:
            high = mid-1
        else:
            low = mid+1


    return -1


nums = [1,2,4,5,6,7,8]

print(find_missing(nums))