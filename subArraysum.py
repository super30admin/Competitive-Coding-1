# Time Complexity :- O(n**2)
# Space complexity :- O(1)

# Ran on leetcode :- No. TLE error
# First I thought sliding window approach would work. But it didn't. Need to figure out more
# optimized solution

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        
        # Store total count
        total = 0
        
        for start in range(len(nums)):
            sum_array = 0
            for end in range(start,len(nums)):
                sum_array += nums[end]
                if sum_array == k:
                    total += 1
                
        return total