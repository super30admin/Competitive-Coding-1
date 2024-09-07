def missingNumber(arr):
    # Brute force method
    # for i in range(len(arr)):
    #   if  i+1 != arr[i]:
    #     return i+1
    # return -1
    # binary method
    n = len(arr)
    l = 0
    h = len(arr)-1
    while l <= h:
        mid = (l+h)//2
        if arr[l] - l == 1 and arr[mid] - mid == 1:
            l = mid + 1
        elif arr[h] - h == 1 and arr[mid] - mid == 1:
            h = mid - 1
        else:
            return mid + 1
        
    return -1

    

# Driver Code
arr = [1,2,3,5,6,7,8]

number = missingNumber(arr)
print(number)  # Output: 5