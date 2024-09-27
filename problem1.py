# Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.

# Examples:
# Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
# Output : 4

# Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]
# Output : 3


# in the array there is a pattern arr[index] is always equal to index+1
# check for which index the difference between array[index]  and array[index+1] is 2, then return that index + 2 as answer

# brute force would be linear search
# modify binary search
# as long as array[index] - index == 1  make low = mid + 1
# else make high = mid -1

# time complexity - O(log n)
# space complexity - constant
def findMissing(array):
    low, high = 0, len(array)-1
    if(array[0] != 1):
        return 1
    while(low <= high):
        mid = (low + high)//2
        if(array[mid+1]-array[mid] == 2):
            return mid+2
        elif(array[mid] - mid == 1):
            low = mid + 1
        else:
            high = mid -1
    return -1

print(findMissing([1, 2, 3, 5, 6, 7, 8]))
print(findMissing([1, 2, 4, 5, 6, 7, 8, 9]))
print(findMissing([1, 2,3, 4, 5, 6, 7, 9]))
