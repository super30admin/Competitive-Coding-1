# APPROACH:1 BRUTE FORCE SOLUTION
# Time Complexity : O(n^2) - n is the length of nums
# Space Complexity : O(n) - n is the size of set same as the length of nums
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach
# 1. Create a set and store all numbers from 0 to n in it. 
# 2. For each element in set, check if the number exist in nums. (Can do other way - for each num in nums, check whether in set but need to keep track of which all numbers are seen)
# 3. Return that element which is not present in nums

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        if not nums:
            return None
        
        set_nums = set()
        for num in range(0, len(nums) + 1):
            set_nums.add(num)
            
        for num in set_nums:
            if num not in nums:
                return num
                
                
# APPROACH:2 BRUTE FORCE SOLUTION / INTERMEDIATE one
# Time Complexity : O(n) - n is the length of nums
# Space Complexity : O(n) - n is the length of the list created which is passed to sum for total_sum
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach
# 1. Find the total sum ie., sum of list of all elements from 0 to n 
# 2. Find the sum of given list - nums
# 3. Get the difference of above 2 sums and that's the missing element.

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        if not nums:
            return None
        
        total_sum = sum([i for i in range(len(nums) + 1)])
        nums_sum = sum([i for i in nums])
        
        return total_sum - nums_sum
            
        
# APPROACH:3 OPTIMAL SOLUTION
# Time Complexity : O(n lg n) actually.   O(lg n) - n is the length of the sorted array (here I have sorted it as input is unsorted in leetcode)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes (need to sort the input)
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach
# 1. Initialize start to 0 and end to len(nums) - 1. Compute mid
# 2. If mid (index) not same as nums[mid] (array value) -> check its difference with it's left neighbor -> If 2, then found the missing element - nums[mid] - 1
#                                                                                                        -> We have overshot the missing elment, need to go to the part before 
#                                                                                                        this element (left side of it)
# 3. If mid (index) not same as nums[mid] (array value) -> need to go right of it as all elements before this element are present as ind == arr[ind]


class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        if not nums:
            return None
        
        nums.sort()
        
        start, end = 0, len(nums) - 1
        while start <= end:
            mid = start + (end - start) // 2
            
            if mid != nums[mid]:
                if mid == 0 or nums[mid] - nums[mid - 1] == 2:
                    return nums[mid] - 1
                else:
                    end = mid - 1
                    
            else:
                start = mid + 1
                
        return len(nums)
            
        
# ANOTHER WAY OF IMPLEMENTING
class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        
        if nums is None:
            return None
        
        nums.sort()
        if nums[0] != 0:
            return 0
        
        start, end = 0, len(nums) - 1
        while start <= end:
            mid = start + (end - start) // 2
            
            if nums[mid] > mid:
                if nums[mid - 1] == mid - 1:
                    return mid
                else:
                    end = mid - 1
                    
            elif nums[mid] == mid:
                start = mid + 1
                
        return len(nums)
        
