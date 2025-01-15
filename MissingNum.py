#Approach 1: Python3
class Solution:
    def missingNumber(self, arr: List[int]) -> int:
        size = len(arr)
        low = 0
        high = size - 1

        while high - low >= 2:
            mid = low + (high - low) // 2
            low_idx_diff = arr[low] - low
            mid_idx_diff = arr[mid] - mid

            if low_idx_diff != mid_idx_diff:
                high = mid
            else:
                low = mid

        return (arr[low] + arr[high]) // 2




