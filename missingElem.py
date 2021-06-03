#time complexity : O (log n)
# space complexity: O(1)
# Runs on leetcode: Yes

class Solution:
    def search(self, arr, size):
        low, high = 0, size - 1

        while high - low >= 2:
            mid = int(low + (high - low) / 2)
            if arr[low] - low == arr[mid] - mid:
                low = mid
            else:
                high = mid

        return (arr[high] + arr[low]) // 2


obj = Solution()
print(obj.search([1,2, 4, 5, 6, 7], 6))
