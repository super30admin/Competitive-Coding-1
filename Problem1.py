"""
I used binary search to find the missing number in a sorted array of natural numbers. At each step, I checked if the element matched its expected value (mid + 1). Based on that, I adjusted the search range to locate the missing position.
Time Complexity: O(log n)
Space Complexity: O(1)
"""
def missingNumber(nums):
    low = 0
    high = len(nums) - 1
    while(low <= high):
        mid = low  + (high - low) // 2
        if nums[mid] == mid + 1:
            low = mid + 1
        else:
            high = mid - 1
    return low + 1