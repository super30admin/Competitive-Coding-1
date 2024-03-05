# time complexity is O(logN) and space complexity O(1)
class FindMissingNumber:
    def MissingNumber(self, arr):
        if arr[0] != 1:
            return 1
        if arr[len(arr)-1] !=  len(arr)+1:
            return len(nums)+1
        
        l = 0
        r = len(arr)-1
        
        while l <=r:
            mid = (l+r)//2        
            if arr[mid] != mid+1 and arr[mid-1] == mid:
                return mid+1      
            if arr[mid] == mid + 1:
                l = mid + 1
            else:
                r = mid - 1 
        return -1

fmn = FindMissingNumber()
res = fmn.MissingNumber([1, 2, 4])
print(res)  
                