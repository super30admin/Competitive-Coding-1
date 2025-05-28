# Missing Number in Sorted Array of Natural Numbers
# https://www.geeksforgeeks.org/problems/missing-number-in-sorted-array-of-natural-numbers/1

# Author : Akaash Trivedi
# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :  Runs on Geeksforgeeks 
# Any problem you faced while coding this : No

def missingNumber(arr):
        # code here
        if arr == None:
            return
        low = 0
        high = len(arr) -1
        if arr[low] != 1:
            return 1
        if arr[high] != len(arr)+1:
            return len(arr)
        while low < high:
            mid = low + (high - low)//2
            if low == mid:
                break
            elif arr[mid] == mid+1:
                low = mid
            else:
                high = mid
        return arr[low] +1
        

