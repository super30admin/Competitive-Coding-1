# Time complexity: O(n log n) if we need to sort the array, 
# or O(log n) if the array is already sorted

# Space complexity: O(1) as we only use a constant amount of extra space

# Could not solve in the Mock interview

def search(nums):

    actual_length = len(nums)+1

    # Edge cases
    # first element is 1 given in the estion
    if(nums[0] != 1):
        return 1
    # last element will always lengh + 1
    if(nums[-1] != (actual_length)):
        return actual_length

    # initializing pointers
    left = 0
    right = len(nums) - 1

    while left <= right:
        mid = left + (right - left) // 2
        
        # If the current number matches its expected position (index + 1),
        # the missing number must be on the right side
        if nums[mid] == mid + 1:
            left = mid + 1
        # If the current number is greater than its expected position,
        # the missing number must be on the left side
        else:
            right = mid - 1
    
    # When the binary search completes, 'left' points to the correct position
    return left + 1


# Driver Code
a = [1, 2, 3, 4, 5, 6, 8]
b = [2, 3, 4, 5, 6]
c = [1, 2, 3, 4]
print("Missing number:", search(a))
print("Missing number:", search(b))
print("Missing number:", search(c))