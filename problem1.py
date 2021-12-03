# Time Complexity : O(log(n))
# Space Complexity : 0(1)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approach

#Binary Search Approach
'''
[ 1, 2, 3, 4, 5, 7, ]
  0  1  2  3  4  5  

'''
def missing_num(nums: List[int]) -> int:
    if len(nums) < 2:
        return None
    l = 0
    r = len(nums)-1
    if nums[0] == 2:
        return 1 
    while l<=r:
        mid = (l+r)//2
        if nums[mid-1]== mid and nums[mid]!=mid+1 :
            return mid+1
        elif nums[mid-1]==mid:
            l = mid+1
        else:
            r = mid-1
    return None    

# print(missing_num([2,3,4,5]))
# print(missing_num([1,2,3,5,6,7]))
# print(missing_num([1,2,3,4,5,7]))
