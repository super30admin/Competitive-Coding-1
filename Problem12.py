# Given a sorted array arr[] of n-1 integers, these integers are in the range of 1 to n. There are no duplicates in the array. One of the integers is missing in the array. Find the missing integer. 
# Examples: 

# Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
# Output : 5
# Explanation: The missing integer in the above array is 5 

# Input : arr[] = [1, 2, 3, 4, 5, 6, 8, 9]
# Output : 7
# Explanation: The missing integer in the above array is 7 


# Time Complexity : O(log n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : ran of GfG
# Any problem you faced while coding this : no

#Approach: after every iteration, low only ever advances into the true condition and wont proceed the false condition so it becomes easy to track low


def findMissingInteger(arr):
    n=len(arr)+1 #plus 1 for actual length since current arr has 1 less
    if n==1: return 1
    low=0
    high=len(arr)-1
    
    while(low<=high):
        mid=(low+high)//2
        if(arr[mid]==mid+1):
            low=mid+1
        else:
            high=mid-1
    return low+1
