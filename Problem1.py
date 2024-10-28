def binarySearchmis(arr, l ,h) -> int:
    while (l<=h):
        mid = (l + h)//2
        if mid ==len(arr)-1 or (mid == arr[mid]-1 and mid + 1 == arr[mid+1] - 2):
            return arr[mid] + 1
        if mid == 0 or (mid == arr[mid] - 2 and mid - 1 == arr[mid-1] - 1):
            return arr[mid] - 1
        elif mid < arr[mid] - 1:
            return binarySearchmis(arr, l, mid-1)
        else:
            return binarySearchmis(arr, mid+1, h)
    return arr[h]+1 


arr= [2,3,4]

print(binarySearchmis(arr,0,len(arr)-1))
