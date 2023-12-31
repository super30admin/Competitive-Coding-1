# Time Complexity: O(log n)
# Space Complexity: O(1)
nums = [1,3,4,5,6]
low = 0
high = len(nums) - 1
value_gap = 0
index_gap = 0

while low <= high:
    mid = low + (high-low) // 2
    # print(mid)

    if mid > 0 and nums[mid-1] != nums[mid] - 1:
        print(nums[mid] - 1)
        break
    if mid < (len(nums)-1) and nums[mid+1] != nums[mid] + 1:
        print(nums[mid] + 1)
        break
    value_gap = nums[mid] - nums[low]
    index_gap = mid - low
    if value_gap == index_gap:
        low = mid + 1
    else:
        high = mid - 1
