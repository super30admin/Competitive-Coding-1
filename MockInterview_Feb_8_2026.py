#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Feb  8 17:20:19 2026

@author: rishigoswamy

Problem:
    ----------
    Given an array nums containing n distinct numbers in the range [0, n], 
    return the only number in the range that is missing from the array.

Constraints:
    ----------
    n == nums.length
    1 <= n <= 104
    0 <= nums[i] <= n
    All the numbers of nums are unique.
    The list is sorted in increasing order
    
Approach:
    ----------
    Since the array is sorted and contains distinct values in the range
    [0, n], the correct value at index i should be nums[i] = i if no
    number is missing.

    We use binary search to find the first index where this condition
    breaks, i.e., nums[mid] > mid.
    If nums[mid] > mid, the missing number lies on the left half;
    otherwise, it lies on the right half.

    At the end of the binary search, the variable `low` points to the
    missing number, which is returned.

Time Complexity:
----------------
    O(log n), due to binary search on the sorted array.

Space Complexity:
-----------------
    O(1), as the algorithm uses constant extra space.
    

"""

class Solution:
    def missingNumber(self, nums) -> int:

        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = (low+high)//2
            if mid < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        
        return low
