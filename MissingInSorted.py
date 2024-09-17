'''
    Time Complexity:
        O(log(n))

    Space Complexity:
        O(1)

    Did this code successfully run on LeetCode?:
        Couldn't find this on LeetCode.

    Problems faced while coding this:
        Couldn't figure out the termination condition of the loop.

    Approach:
        The goal is to find two adjacent indices in the array between which the number is missing.
        If the diff of number and index at low isn't equal to the diff of number and index at mid, then the missing number is between the left half, so move high = mid.
        Else the diff is in the right half, so move low = mid.
        Return the avg of numbers at low and high.
'''
def search(arr):
    low = 0
    high = len(arr) - 1

    while high - low >= 2:
        mid = low + (high - low) // 2

        if arr[low] - low != arr[mid] - mid:
            high = mid
        else:
            low = mid

    return (arr[low] + arr[high]) // 2
