def find_missing_number(nums):
    left, right = 0, len(nums) - 1

    while left <= right:
        mid = (left + right) // 2
        # Expected value at index mid should be mid + 1
        if nums[mid] != mid + 1:
            # If it's the first incorrect value or the previous value is correct, we found the missing element
            if mid == 0 or nums[mid - 1] == mid:
                return mid + 1
            right = mid - 1
        else:
            left = mid + 1

    return -1


# Test cases
arr1 = [1, 2, 3, 4, 6, 7, 8]
arr2 = [1, 2, 3, 4, 5, 6, 8, 9]

print(find_missing_number(arr1))  # Output: 5
print(find_missing_number(arr2))  # Output: 7
