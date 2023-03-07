# Find the Missing Number in a sorted array

def search(arr, size):
# Extreme cases
    if arr[0] != 1:
        return 1
    if arr[size-1] != size+1:
        return size + 1
    
    low = 0
    high = size - 1
    while high - low >= 2:
        mid = (low+high) // 2
        if (arr[low]-low) != (arr[mid]-mid):
            high = mid
        else:
            low = mid
    return (arr[low] + arr[high]) // 2

arr = [1,2,3,4,5,7,8]
print("Missing number:", search(arr, 7))
