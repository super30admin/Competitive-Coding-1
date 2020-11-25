# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : NA 
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach : 
# Approach
"""
Since it is a srted array Using binary search helps in solving problem 
with O(log n) complexity. The elements before missing will bee 1 minus and the
nums[i]-i=1 and after will be nums[i]-i=2.

"""
def search(nums):
    left=0
    right=len(nums)-1
    #middle=0
    while(right > left +1):
         middle=(right+left)//2
         if(nums[left]-left) != (nums[middle]-middle):
            right=middle
         elif (nums[right]-right)!=(nums[middle]-middle):
            left=middle
    return nums[middle]+1


a=[1,2,3,5]
ans=search(a)
print(ans)




