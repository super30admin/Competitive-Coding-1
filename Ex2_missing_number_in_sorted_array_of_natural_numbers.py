# Time Complexity : O(log n), where n is the number of elements in the array
# Space Complexity : O(1), no extra space used
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No

from typing import List

class Solution:

    def missingNumber(self, arr: List[int]) -> int:
        l = 0
        h = len(arr) - 1

        if arr[0] != 1:
            return 1

        while l <= h:
            mid = (l + h) // 2

            # Check left gap
            if mid > 0 and arr[mid] - arr[mid - 1] > 1:
                return arr[mid - 1] + 1

            # Check right gap
            if mid < len(arr) - 1 and arr[mid + 1] - arr[mid] > 1:
                return arr[mid] + 1

            # Decide search direction
            if arr[mid] == mid + 1:
                l = mid + 1
            else:
                h = mid - 1

        # Missing number is after the last element
        return arr[-1] + 1  

# --------------------------------------------------

        # Brute Force Approach
        # Time Complexity : O(n)
        # Space Complexity : O(1)

        # for i in range(len(arr)):
        #     if arr[i] != i + 1:
        #         return i + 1
        # return len(arr) + 1  # missing at the end




if __name__ == "__main__":
    sol = Solution()
    print(sol.missingNumber([1, 2, 3, 4, 6, 7, 8]))   # Output: 5
    print(sol.missingNumber([1, 2, 3, 4, 5, 6, 8, 9])) # Output: 7
    print(sol.missingNumber([2, 3, 4, 5]))             # Output: 1
    print(sol.missingNumber([1, 3]))                   # Output: 2
    print(sol.missingNumber([1, 2]))                   # Output: 3