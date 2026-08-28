#Time Complexity : O(log(n))
#Space Complexity : O(1)
#Did this code successfully run on Leetcode :Yes
class Solution:
    def findMissingNumber(self, ar: List[int]) -> int:
        low = 0
        high = len(ar) - 1
        a = -1 
        while low <= high:
            mid = low + (high - low) // 2
            if ar[mid] - mid == ar[0] - 0:
                a = mid   
                low = mid + 1
            else:
                high = mid - 1
        return ar[a] + 1
