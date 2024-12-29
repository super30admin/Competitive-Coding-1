# Find Missing Number in a sorted array

# T: O(log n ), S: O(1)
def findMissingNum(nums):
    l, r = 0, len(nums) - 1

    while l < r: # Why not = ?
        m = (l + r) // 2
        if nums[m] == m + 1: # Missing num is to the R
            l = m + 1
        else: # Missing num is to the L
            r = m
    # Missing num is at l as hinted by the interviewer
    return l + 1