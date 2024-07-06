"""
Problem:
Find Missing Number in a sorted array

I/P: [1,2,3,4,5,6,7,9,10]
O/P: 8

I/P: [2,3,4,5,6,7,8,9,10]
O/P: 1

Mock Interview Solutions
Find Missing Number in a sorted array
https://youtu.be/LwmckBrlrRs

Time Complexity : O(logn) 
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
We're going to use the binary search to ignore the half part of the list based of whether arr[mid] == mid+1 which means all the elements
are in sorted order and there is no missing until mid so we move towards the right side of the array. We also check if arr[mid] > mid+1 which
means our missing element lies towards left side. when we reach terminating condition i.e., low <= high, we have found our missing element at low+1. 
"""

def find_missing_element(arr):
    low, high = 0, len(arr) - 1

    while low <= high:
        mid = low + (high - low) // 2

        if arr[mid] == mid + 1:
            low = mid + 1
        elif arr[mid] > mid + 1:
            high = mid - 1

    return low + 1

print(find_missing_element([1,2,3,5,6,7]))
print(find_missing_element([1,2,3,4,5,6,7,9,10]))
print(find_missing_element([1,2,4,5,6,7,8,9,10]))
print(find_missing_element([2,3,4,5,6,7]))
      


