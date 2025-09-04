# Time Complexity : O(log n) as we are dividing the size of the array by half for every iteration
# Space Complexity : O(1) no extra space used.
# Did this code successfully run on Geeks for Geeks : Yes
# Any problem you faced while coding this : No

class Solution:
    def missingNumber(self, arr):
        # code here
        low = 0
        high = len(arr) - 1

        while (low <= high):
            mid = low + (high - low) // 2
            if mid + 1 == arr[mid]:
                low = mid + 1
            elif mid + 1 != arr[mid]:
                if arr[mid] - 1 != arr[mid - 1]:
                    return arr[mid] - 1
                else:
                    high = mid - 1

        return arr[-1] + 1