def findMissing(arr):
    left = 0
    right = len(arr)-1

    while left <= right:

        mid = left + (right-left)//2

        if arr[mid] == arr[mid-1]+2:
            return arr[mid]-1

        else:
            if arr[mid] == mid+1:
                left = mid+1
            elif arr[mid] == mid + 2:
                right = mid - 1

    return -1

print(findMissing([1,2,3,4,5,7]))
