
# find the only missing number in a sorted
# in a sorted array of distinct elements

 
 
def search(arr, n):
    left = 0 
    right = n-1 
    while left < right: 
        mid = left + (right-left)//2 
        if arr[mid] - mid != arr[left] - left : 
            right = mid - 1 
        else :
            left = mid + 1 
    return arr[left]-1 
        

   
 

arr = [1, 2, 3, 5, 6, 7, 8]
n = len(arr)
 
print("Missing number:", search(arr, n))
 
