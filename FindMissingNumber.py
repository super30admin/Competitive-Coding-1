#Time Complexity : O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : yes, although leetcode wanted a linear solution
#Any problem you faced while coding this :

def findMissingNumber(nums):
    left = 0
    right = len(nums) - 1
    mid = 0
    #we do a binary search on the elements, here we'll use the indices as a clue to which number is missing
    while right > left + 1:
        mid = (left + right) // 2
        if (nums[left] - left) != (nums[mid] - mid):
            right = mid
        elif (nums[right] - right) != (nums[mid] - mid):
            left = mid
    return nums[mid] + 1