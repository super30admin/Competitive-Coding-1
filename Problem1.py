
'''
Problem: Find missing number  https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/
Time Complexity: O(log n), where n is given elements
Space Complexity: O(1)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        since array is sorted, we can apply binar search
        wherever index and number differs than 1, we move our right pointer
        else move left pointer   
'''

def missing(nums):
    left = 0
    right = len(nums)-1
    
    while left < right:
        mid = (right+left)//2
        if nums[mid] - mid == 1:
            left = mid +1
        else:
            right = mid
    
    return left+1

print(missing([1,2,3,5])) #4
print(missing([2,3,4,5])) #1
print(missing([1, 2, 3, 4, 6, 7, 8])) #5
print(missing([1, 2, 3, 4, 5, 6, 8, 9])) #7
print(missing([1, 3, 4, 5, 6])) #2
print(missing([1, 2, 4, 5, 6])) #3

