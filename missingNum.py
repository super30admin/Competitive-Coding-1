#Time Comlexity:   O(1)
#Space Complexity: O(1)
#Ran succeefully on leetcode: Yes
# Here I am finding the sum of the elements in the given array. And  also the sum of the number in the range of the length of the given array.
# Subtract the sum of the elemnts in the array from the other. 
class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        return sum(range(len(nums)+1)) - sum(nums)    
    
