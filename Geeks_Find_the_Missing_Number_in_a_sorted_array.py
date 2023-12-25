# Description
# Link: https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/
# Given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list. One of the integers is missing in the list. Write an efficient code to find the missing integer. 
# Examples: 

# Input : arr[] = [1, 2, 3, 4, 6, 7, 8]
# Output : 5

# Input : arr[] = [1, 2, 3, 4, 5, 6, 8, 9]
# Output : 7

# Solution

# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : NA
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Approach is to use Binary search to check if the mid value is matching index+1. Since this is a [1,n] array. If matching then
# missing number will be on the right part of the array. If not matching then we need to consider the first half, first half
# should have the value. We will end up at one value whose index is not matching giving us the missing number, or we will end up
# in a point where the previous has the issue but now we dont have the issue, so previous was the issue

def solution(arr):
    low = 0
    high = len(arr)-1

    while low<=high:
        if low == high:
            if arr[low] == low+1:
                return low+2
            else:
                return low+1
        
        mid = (low+high)//2

        if arr[mid] == mid+1:
            low = mid+1
        else:
            high = mid-1

if __name__ == "__main__":
    arr = [1,2,3,4,5,6,8]
    print(solution(arr))
