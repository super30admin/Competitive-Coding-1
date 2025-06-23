'''
Time complexity: O(log N)
Space complexity: o(1)
'''

class FindMissingNumberInSortedArray:
        
    def findMissingNumber(self, arr):
        low = 0 
        high  = len(arr) - 1 

        if arr[0] != 1:
            return 1

        if arr[high] != (high + 1):
            return high + 1 


        while low<=high:
            mid = low + (high - low)//2
            if arr[low]-low != arr[mid]-mid: 
                high = mid
            if arr[high]-high != arr[mid]-mid:
                low = mid 

            return arr[low]+1


arr = [1,2,4,5]

find = FindMissingNumberInSortedArray()

print(find.findMissingNumber(arr))
                
                

    


