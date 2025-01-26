# Time Complexity : O(logn)
# Space Complexity : O(1)

"""
I will be using binary search to discard the side where the missing number will not be there:
If mid is at the correct position, left side is correct so discard left side
If mid is not at the correct position, missing number is on the left side so discard the right side.
"""


def findMissingNumber(lst):
    n = len(lst)
    low = 0
    high = n - 1

    if lst[0] != 1:
        return 1

    while low <= high:
        mid = low + (high-low )//2
        # if middle number is not at the right position, missing number is on the left side
        if mid + 1 != lst[mid]:
            # discard the right side
            high = mid - 1
        # middle number is at the right position, missing number is on the right side
        else:
            # discard the left side
            low = mid + 1
    # we will come out of the while loop when low crosses high,
    # at this point number after lst[high] would be missing
    return lst[high] + 1
