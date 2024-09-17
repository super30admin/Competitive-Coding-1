""" 
Submitted by : Aryan Singh_RN12MAY2023
Time Complexity : O(log n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Did a small error in caluclating mid initially. Did mid = (l + (h - l)) // 2
Submitting solution to question asked during mock interview: https://leetcode.com/problems/guess-number-higher-or-lower/description/
"""

# The guess API is already defined for you.
# @param num, your guess
# @return -1 if num is higher than the picked number
#          1 if num is lower than the picked number
#          otherwise return 0
# def guess(num: int) -> int:


class Solution:
    def guessNumber(self, n: int) -> int:
        l = 1
        h = n
        mid = 0
        while (l <= h):
            mid = l + (h - l) // 2
            response = guess(mid)
            if response == 0:
                return mid
            elif response == -1:
                h = mid -1
            else:
                l = mid + 1
        return -1
