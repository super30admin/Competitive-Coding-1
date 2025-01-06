def find_missing_number(arr):
    low = 0
    high = len(arr) - 1

    while low <= high:
        mid = low + (high - low) // 2

        # Expected difference if no number is missing
        expected_diff = arr[mid] - (mid + 1)

        if expected_diff > 0:
            high = mid - 1
        else:
            low = mid + 1

    return low + 1


array1 = [1, 2, 3, 5, 6, 7, 8]
print(find_missing_number(array1))  # Output: 4

