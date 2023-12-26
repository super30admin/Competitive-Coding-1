def find_missing_element(nums):
    low = 0
    high = len(nums) - 1
    mid = 0

    while high - low >= 2:
        mid = low + (high - low) // 2

        midIdxDiff = nums[mid] - mid
        lowIdxDiff = nums[low] - low
        highIdxDiff = nums[high] - high

        if midIdxDiff != lowIdxDiff:
            high = mid
        elif midIdxDiff != highIdxDiff:
            low = mid

    return (nums[low] + nums[high]) // 2

# Example 
nums = [1, 2, 3, 4, 5, 6, 8]
missing_element = find_missing_element(nums)
print(f"The missing element is: {missing_element}")
