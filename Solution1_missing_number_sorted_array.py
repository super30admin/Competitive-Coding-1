// Time Complexity : O(logn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode: No
// Any problem you faced while coding this : No

0,1,2,3,4,
1,2,3,4,5

'''
1. check if array mid index+1  is equal mid value
2. if yes move start pointer to mid+1, else end pointer to mid-1
3. Come out of loop when start>end
4. return start+1 value as missing value
'''


def search(nums):
    start =0
    end=len(nums)-1
    
    while start <= end:
        mid = (start+end)//2
        
        if nums[mid] == mid+1:
            start =mid+1
        else:
            end=mid-1
        
    return start+1
            



