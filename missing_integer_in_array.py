'''
Leetcode 268. Missing Number
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

 

Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

'''

class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        '''
        1. Use gauss formula to find the missing number
        2. Calculate the total expected by summing all nums 
        ex: [3,0,1]
        expected total =. length of nums array * (length of nums + 1)//2
        n(n+1)/2 is the formula
        3. Then calculate the actual sum by adding up the elements of nums
        4. subtract expected value from actual vale. that gives the missing number.
        
        TC: O(N)
        SC: O(1)
        
        '''
        nums_total = len(nums) * (len(nums)+1) // 2
        sum = 0
        
        for i in range (len(nums)):
            sum += nums[i]
        
        return (nums_total - sum)
    
        '''
        This method uses XOR operation:
        same bits: output is zero
        different bits: output is one
        
        TC: O(N)
        SC: O(1)
        
        def missingNumber(self, nums: List[int]) -> int:
        s=0
        for i in nums:
            s=s^i
        for i in range(len(nums)):
            s=s^i
        s=s^(i+1)
        return s
        
        '''
        
        