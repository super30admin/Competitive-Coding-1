class Solution:
    def MissingNumber(self,array,n):
        # code here
        low = 0
        high = len(array)-1
        while(low <= high):
            mid = low + (high-low)//2
            
            if array[mid+1] - array[mid] != 1:
                return array[mid] + 1
            elif array[mid] - array[mid-1] != 1:
                return array[mid] - 1
            
            if array[mid]-array[low] != mid - low:
                high = mid - 1
            elif array[high] - array[mid] != high - mid:
                low = mid + 1
        

