# time complexity : O(logn)
# space complexity : O(1)

# array[index] = index + 1 but if it is not then that's the index where the missing number is 
# now to decide in binary search hwo to decide which array left or right array to eliminte while checking, so how to decide the left half/right half is where the missing element is 
# so the simple logic is the number of elements in between the raneg of the arr[high]-arr[mid] should be equal to the number between the indexes with this logic we can know if 
# the left hald or right half does not match the number of elements, that array is where we have our missing element. 

def binary_missing(nums):
    low = 0
    high = len(nums) - 1

    while low <= high:
        mid = low + (high - low) // 2

        # if the missing number is on the left or right
        if high-mid != nums[high] - nums[mid]: 
            low = mid +1
        else: 
            high = mid-1

    # low is the index where the missing number should be
    return low + 1  # missing value

# Example usage
arr = [1, 2, 3, 4, 5, 6, 8]
print(binary_missing(arr))  # Output: 7