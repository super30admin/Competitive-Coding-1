# Time Complexity --> O(logN)
# Space Complexity --> O(1)
# Explanation --> Using a binary search, check if the difference between the middle number and any of its adjacent numbers is greater than 1 and if so then return the output accordingly. 
# If the missing number not adjacent to middle index, go towards the half where the difference between high index and middle index is lower than the difference bewteen corresponding values.

class Solution:
    def missingNumber(self, arr):
        # code here
        n = len(arr)+1 
        low = 0
        high = len(arr)-1
        
        if arr[0]!=1:
            return 1
        if arr[-1]!=n:
            return n
        
        while low<=high:
            mid = low + (high-low)//2
            if arr[mid+1]-arr[mid]>1:
                return arr[mid]+1
            if arr[mid]-arr[mid-1]>1:
                return arr[mid]-1
            if arr[high]-arr[mid] > high-mid:
                low = mid
            else:
                high = mid
        
    
        
