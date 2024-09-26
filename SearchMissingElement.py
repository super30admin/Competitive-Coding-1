'''Time Complexity : O(log n ) Space Complexity: O(1)'''

def searchMissingElement(arr):
    if len(arr)==0:
        return 1
    
    if arr[0] != 1:
        return 1
        
    if arr[len(arr)-1] != len(arr)+1:
        return len(arr)+1
        
    low = 0
    high = len(arr)-1
    
    while low <= high:
        mid=low+(high-low)//2
        if arr[mid]-mid > 1 :
            if arr[mid-1] - mid-1 > 1:
                high= mid-1
            else:
                return mid
        else:
            low = mid + 1
    

a = [1,2,3]


print("Missing number:", searchMissingElement(a))

