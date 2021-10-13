# Find the Missing Number in a sorted array
# https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/

# Time Complexity: O(log n)
# Space Complexity: O(1)

def missNumber(nums):
    start = 0
    end = len(nums) - 1

    if nums[start] != 1:
        return 1
    if nums[end] != len(nums) + 1:
        return end + 2

    while start < end:
        mid = start + (end-start)//2

        if nums[mid] == mid + 1:
            start = mid + 1
        else:
            end = mid
    return start + 1

print(missNumber([1,2,3,4,6,7]))
print(missNumber([1,2,3,4,5,7]))
print(missNumber([1,3,4,5]))