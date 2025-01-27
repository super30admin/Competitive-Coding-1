'''
Time Complexity :   O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
'''

def missing(nums):
    left, right = 0, len(nums)-1
    while(left<=right):
        mid = (left+right)//2
        if nums[mid]!=arr[0]+mid:
            right=mid-1
        else:
            left=mid+1

    return arr[0]+right