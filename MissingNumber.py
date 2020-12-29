class Solution:
    def missingNumber(self, arr: List[int]) -> [int]:
        left = 0
        right = len(arr) - 1
        while left < right:
            mid = left + (right - left) // 2
            if mid + 1 == arr[mid]:
                left = mid + 1
            else:
                right = mid
        return left + 1
