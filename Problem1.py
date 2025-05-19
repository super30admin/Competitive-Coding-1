# Given a sorted array arr[] of n-1 integers, these integers are in the range of 1 to n.
# There are no duplicates in the array. One of the integers is missing in the array.
# Find the missing integer.
# Examples:
# Input: arr[] = [1, 2, 3, 4, 6, 7, 8]

def missingNumber(arr):
    l,r = 0, len(arr) - 1
    
    while l <= r:
        mid = l + (r-l)//2
        # check if mid+1 == arr[mid] if true means the left array is sorted
        # The missing number is in the right array
        if arr[mid] == mid + 1:
            l = mid + 1
        else:
            r = mid - 1
    # l gives the index where the missing number should be there and l+1 is the number
    return l + 1


print(missingNumber([1,2,3,4,6,7,8]))
print(missingNumber([1, 2, 3, 4, 5, 6, 8, 9]))