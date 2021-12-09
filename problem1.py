arr =[1,2,3,5]

def checkMissingElement(arr):
    if arr is None or len(arr) == 0:
        return -1

    low = 0
    high = len(arr)-1

    while(low <= high):
        mid = int(low + (high -low)/2)
        if arr[mid+1] - arr[mid] > 1:
            return arr[mid] + 1
        if arr[mid] - arr[mid-1] > 1:
            return arr[mid] - 1

        if arr[mid] - mid > 1:
            high = mid - 1
        else:
            low = low + 1
    else:
        return -1

print(checkMissingElement(arr))