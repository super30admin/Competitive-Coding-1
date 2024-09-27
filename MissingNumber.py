class MissingNumber(object):
    '''
    Solution:
    1. Use binary search as the array is sorted. Calculate low, mid and high as usual. Calculate the differences of
        array[low] - low and array[mid] - mid.
    2. If first one is smaller, reject the second half else reject the first half and update mid until low is 1 element
        lesser than high.
    3. The missing element would be the middle value between array[low] and array[high].

    --- Assumed array size greater than 1, first and last elements cannot be missing (given during mock interview)
    --- Checked edge cases like [1, 3] and also generic cases, passed all of them.
    '''

    def search(ar, size):

        # O(logn) Time Complexity | O(1) Space Complexity
        low = 0
        high = size - 1

        while (low < high):
            mid = low + int((high - low) / 2)
            diffLow = ar[low] - low
            diffMid = ar[mid] - mid

            if (low == high - 1):
                break

            if (diffLow < diffMid):
                high = mid
            else:
                low = mid

        return int((ar[low] + ar[high]) / 2)