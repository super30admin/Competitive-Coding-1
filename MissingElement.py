# Missing Number in Sorted Array of Natural Numbers
# https://www.geeksforgeeks.org/problems/missing-number-in-sorted-array-of-natural-numbers/1
# https://www.geeksforgeeks.org/dsa/find-the-missing-number-in-a-sorted-array/

# Given a sorted array arr[] of n-1 integers, these integers are in the range of 1 to n. There are no duplicates in the array. 
# One of the integers is missing in the array. Find the missing integer.

# Examples:

# Input: arr[] = [1, 2, 3, 4, 6, 7, 8]
# Output: 5
# Explanation: The missing integer in the array is 5.
# Input: arr[] = [1, 2, 3, 4, 5, 6, 8, 9]
# Output: 7
# Explanation: The missing integer in the array is 7.
# Constraints:
# 1 ≤ arr.size() ≤ 105
# 1 ≤ arr[i] ≤ arr.size()+1

# Method-1: Linear Search
# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on GFG : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Using linear search keep comparing adjacent elements for missing element
class Solution:
    def missingNumber(self, arr):
        if(arr[0] != 1):
            return 1
        
        for i in range(1, len(arr)):
            if(arr[i - 1] + 1 < arr[i]):
                return arr[i - 1] + 1

        # we did not find missing in entire array
        return arr[-1] + 1

print("Method-1: Linear Search")
sol = Solution()
print(sol.missingNumber([1,3,4,5,6]))
print(sol.missingNumber([1,2,4,5,6]))
print(sol.missingNumber([1,2,3,4,6]))
print(sol.missingNumber([2,3]))
print(sol.missingNumber([1,2]))
print(sol.missingNumber([1,2,3,4,5,6,7,9]))
print(sol.missingNumber([1]))


# Method-2: Binary Search
# Time Complexity : O(Log(base2)N)
# Space Complexity : O(1)
# Did this code successfully run on GFG : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here numbers would be from 1 to N. So at every index number should be (index+1). Whereever this is breaking means the number would be 
# missing on the left half. We can apply binary search algo. We find mid, we check if any of the neighbors are missing, keeping in mind
# the boundary conditions of [1,2] and [2,3]. If missing we return the missing left or right. 
# If not missing, we check if mid is at correct index(arr[mid] == mid + 1). If yes, then missing would be in the right half. If no,
# missing would be in the left half. So reduce the half accordingly


class Solution:
    def missingNumber(self, arr):
        low = 0
        high = len(arr) - 1

        while(low <= high):
            mid = (low + (high - low) // 2)

            # case 1: when mid is the first element but the element is missing eg: [2,3]
            # or missing element between index mid - 1 and mid
            if((mid == 0 and arr[mid] != mid + 1) or arr[mid-1] + 1 < arr[mid]):
                return arr[mid] - 1
            
            # case 2: when mid is the last element but it is the correct element and not missing. eg: [1,2]
            # or missing element between index mid and mid + 1
            elif((mid == len(arr) - 1 and arr[mid] == mid + 1) or (arr[mid] + 1 < arr[mid + 1])):
                return arr[mid] + 1

            # if the neighbors are correct or not
            elif(arr[mid] == mid + 1):

                # move towards right side
                low = mid + 1

            else:
                # move towards left side
                high = mid - 1


        return -1

print("Method-2: Binary Search")
sol = Solution()
print(sol.missingNumber([1,3,4,5,6]))
print(sol.missingNumber([1,2,4,5,6]))
print(sol.missingNumber([1,2,3,4,6]))
print(sol.missingNumber([2,3]))
print(sol.missingNumber([1,2]))
print(sol.missingNumber([1,2,3,4,5,6,7,9]))
print(sol.missingNumber([1]))