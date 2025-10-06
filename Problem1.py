class Solution:
    def missingNumber(self, arr):
        # code here
        if len(arr) == 1:
            return len(arr)
            
        low, high = 0 , len(arr)-1
        while low < high:
            mid = (low+high)//2
            #verify left half
            if arr[mid] == mid+1: #O(c)
                low = mid + 1
            else: #verify right half
                high = mid - 1
        
        if (low == 0 and arr[low] == 1) or arr[low] == low+1: 
            return arr[low] + 1
        
        return arr[low] - 1

