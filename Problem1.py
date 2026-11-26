#Given a sorted array arr[] of n-1 integers, these integers are in the range of 1 to n. There are no duplicates in the array. One of the integers is missing in the array. Find the missing integer.
# Examples:
# Input : arr[] = [1, 2, 3, 4, 6, 7, 8]
# Output : 5
# Explanation: The missing integer in the above array is 5 

class Solution:

    def missingNumber(self, arr):
        l, r = 0, len(arr) - 1

        while l <= r:
            m = l + (r - l) // 2
            if arr[m] - m == 1:
                l = m + 1
            else:
                r = m - 1

        return l + 1

arr = [1, 2, 3, 4, 6, 7, 8]
sol = Solution()
print(sol.missingNumber(arr))