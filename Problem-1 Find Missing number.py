# // Time Complexity : O(log n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# Iterate untill 3 consecutive numbers are selected => l-h=2
# Find the difference between the mid,low and high index with its value
# Compare the mid difereence with low and high
# if mid difference is not equal to high difference then missing number exist on the right of mid so move the low ti the right
# Else the missing no is on the left so move the high to the left
# Once the l and h are 2 points away return the average of the values as they are in ap
 


class Solution():
    def findMissingnumber(self,nums):
        l = 0
        h = len(nums) - 1
        
        while h-l >= 2:
            mid = (l+h) // 2
            lindex = nums[l] - l 
            hindex = nums[h] - h
            mindex = nums[mid] - mid
            
            if (mindex != lindex):
                h = mid
            elif (mindex != hindex):
                l = mid
                
        return (nums[l] + nums[h]) // 2
    
    
print(Solution().findMissingnumber([2,3,4,5,6,8,9,10]))