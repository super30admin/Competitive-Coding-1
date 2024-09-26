'''
Find missing element in sorted array in range 1 to n
Time complexity: O(logn)
Space complexity: O(1)
'''
class Solution:
    def findMissingElement(self, arr):
        low = 0
        high = len(arr) - 1
        while low < high:
            mid = low + (high - low)/2
            if low == mid:
                break
            if arr[low] - low != arr[mid] - mid:
                high = mid
            elif arr[high] - high != arr[mid] - mid:
                low = mid
        return arr[mid] + 1

sol = Solution()
print(sol.findMissingElement([1, 3]))