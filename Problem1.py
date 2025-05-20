"""
Ideally an  element at index i is arr[0] + i if no number is missing.
We apply BS to find the first index i where arr[i] != arr[0] + i.
So, the missing number will be at arr[0] + i.
"""
"""
Time Complexity: O(log n) - Binary search is used
Space Complexity: O(1) - Constant extra space
"""

class Problem1:
    def missingNum(self,arr):
        left, right = 0, len(arr) - 1
        start = arr[0]

        while left <= right:
            mid = (left + right) // 2
            expected = start + mid

            if arr[mid] == expected:
                left = mid + 1
            else:
                right = mid - 1

        return start + left

if __name__=="__main__":
    obj = Problem1()
    arr = [1, 2, 3, 4, 6, 7, 8]
    print(obj.missingNum(arr))
