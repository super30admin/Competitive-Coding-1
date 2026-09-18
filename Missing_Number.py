// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Not on LeetCode
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
#I have used Binary Search for this approach. I have checked the index of each number since the array starts from 1 to n.
#So if the mid index is equal to number in mid index + 1 that means there is no missing number on left so need to move right else move left


class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        if not nums:
            return 1
        for i in range(len(nums)):
            if nums[i] != i+1:
                return i+1


class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        if not nums:
            return 1
        #Extreme Cases
        n = len(nums)-1
        if nums[0] != 1:
            return 1
        if nums[n] != n + 1:
            return n + 1
        low = 0
        high = len(nums)-1
        while low <= high:
            mid = low + (high-low) // 2
            if nums[mid] == mid + 1:
                low = mid + 1
            else:
                high = mid - 1
        return low + 1