class MissingNumber(object):
    
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