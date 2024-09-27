'''
Time Complexity - O(N)
Space Complexity - O(1)

Approach Bit manipulation XOR operation
'''

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        
        if len(nums)==0 or nums == None:
            return 0
        
        missing_num = len(nums)
        
        for i in range(len(nums)):
            missing_num = missing_num ^ i ^ nums[i]
            
        return missing_num
            
        

'''
Method 2

Time Complexity - O(N)
Space Complexity - O(N)

Using an extra data structure hashset

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        
        if len(nums)==0 or nums == None:
            return 0
        
        num_set = set(nums)
        
        for num in range(len(num_set)+1):
            
            if num not in num_set:
                return num
            
        return -1
            
        
'''




'''
Method 3

Time Complexity- O(NlogN) sorting complexity 
Space Complexity - O(1) or O(n)

In the sample code, we sorted nums in place, allowing us to avoid allocating additional space. 
If modifying nums is forbidden, we can allocate an \mathcal{O}(n)O(n) size copy and sort that instead 

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        
        if len(nums)==0 or nums == None:
            return 0
        
        nums.sort()
        
        for i in range(len(nums)):
            
            if nums[i]!=i:
                return i
            
        return nums[len(nums)-1]+1
        
'''
            