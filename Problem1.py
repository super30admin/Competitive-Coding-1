# Problem 1 Find Missing Number in a sorted array
# Time Complexity: O(log N) where N denotes the number of elements in an array
# Space Complexity: O(1)

def missingNumber(arr):
    if arr[0] != 1:
        return 1
    high=len(arr)-1
    low=0
    while low<=high:
        mid=(low+high)//2
        if arr[mid]==mid+1:
            low=mid+1
        else:
            high=mid-1
    return low+1


arr=[1,2,3,4,5,7,8,9]
print(missingNumber(arr))