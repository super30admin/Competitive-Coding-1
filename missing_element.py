# TC: O(log(n)); SC: O(1)
class Solution:
    def missingElement(self, arr):
        start = 0
        end = len(arr)-1
        while start <= end:
            mid = start + (end-start)//2
            if mid != 0 and abs(arr[mid] - arr[mid-1]) != 1:
                return arr[mid] - 1
            elif mid != len(arr)-1 and abs(arr[mid] - arr[mid+1]) != 1:
                return arr[mid] + 1
            elif arr[mid] - arr[start] != mid - start:
                end = mid - 1
            else:
                start = mid + 1
        return -1


print(Solution().missingElement([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 17]))
