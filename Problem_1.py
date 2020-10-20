"""
Time Complexity : O(log n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Dont have premium, ran it here
Any problem you faced while coding this : Understood it after seeing the interview. Could not
reach it during mock interview. The  one I gave in mock is below and is optimal in case array
starts fro 1. In case array does not start from one, tha optimal solution is also given


Your code here along with comments explaining your approach
Here, we will be calculating the difference with edge values. 
"""

# Find missing number in a sorted array. Below is my version, that I gave in mock interview


def search(a, n):
    low = 0
    high = n-1
    while low <= high:
        mid = low + (high-low)//2
        if a[mid] != mid+1:
            if mid == 0 or a[mid-1] == mid:
                return mid+1
            else:
                high = mid-1
        elif a[mid] == mid+1:
            low = mid+1
# Optimal solution, for every case, not just the array starting from 1


def optimalSearch(a, n):
    low = 0
    high = n-1
    while high-low >= 2:
        mid = low + (high-low)//2
        midIdx = a[mid]-mid
        lowIdx = a[low]-low
        highIdx = a[high]-high
        if midIdx != lowIdx:
            high = mid
        elif highIdx != midIdx:
            low = mid
    return int((a[high]+a[low])/2)


# Driver Code
a = [3, 5, 6, 7, 8]
n = len(a)

print("Missing number:", optimalSearch(a, n))
