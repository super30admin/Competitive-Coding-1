# Time complexity: O(log n) where n is the length of the array.
# Space complexity: O(1).

def search(nums, size):
    low = 0
    high = size - 1
    while (high - low) >= 2:
        mid = low + (high - low) // 2    # To prevent integer overflow.
        middiff = nums[mid] - mid
        lowdiff = nums[low] - low
        if middiff != lowdiff:
            high =  mid
        else:
            low = mid
    return (nums[low] + nums[high]) // 2

nums = [1, 2, 3, 5, 6, 7, 8]
size = len(nums)
print("Missing number: ",search(nums, size))