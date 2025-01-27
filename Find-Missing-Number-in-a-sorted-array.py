# tc O(log n), sc O(1).
start, end = 0, len(nums) - 1

while start <= end:
    mid = start + ((end - start) // 2)

    # find missing numbers upto mid index
    missing_nums = nums[mid] - nums[0] - mid
    if missing_nums < k:
        start = mid + 1
    else:
        end = mid - 1
    
missing_nums_upto_end = nums[end] - nums[0] - end
return nums[end] + (k - missing_nums_upto_end)