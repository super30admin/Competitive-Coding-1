"""
https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/

Given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list. One of the
integers is missing in the list. Write an efficient code to find the missing integer.

Runtime Complexity: O(logn)
Space Complexity: O(1)
"""

def missingNumber(nums):
    low = 0
    high = len(nums)-1

    while(low<=high):
        mid = low + (high-low)//2

        if nums[mid-1] != nums[mid] - 1:
            return nums[mid]-1

        if nums[mid+1] != nums[mid] + 1:
            return nums[mid]+1

        if nums[mid] == mid + 1:
            low = mid + 1
        else:
            high = mid - 1


nums = [1, 2, 3, 4, 6, 7, 8, 9]
print(missingNumber(nums))