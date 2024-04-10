#Problem 1: Find Missing Number in a sorted array


# Aprroach
# Run Binary Search on the give array. Set low = 0 & high = len(arr)-1. Calculate mid
# Check if difference between value of mid and mid-1 == 1, if not return value of mid-1. Similarly, check if difference between value of mid+1 and mid == 1, if not, return mid+1
# If both adjacent elements are correct, check if the difference between the value and index == 1, if it not, it means value on the left is missing and set high = mid -1 else set low = mid+1

# Time Complexity: O(log n)
# Space Complexity: O(1)

def findMin(arr):
    if arr[0] !=1:
        print(1)
        return
    
    low = 0
    high = len(arr)-1
    while(low<=high):
        mid = low+(high-low)//2
        if (mid != 0 and arr[mid] - arr[mid-1] != 1):
            print(arr[mid]-1)
            return
        elif (mid != len(arr)-1 and arr[mid+1] - arr[mid] != 1):
            print(arr[mid]+1)
            return
        elif arr[mid] - mid == 1:
            low = mid+1
        else:
            high = mid-1
            
    return -1

findMin([1,2,3,5,6])