#time complexity =	O(log n + m)
#Space complexity = O(m)

def find_missing(arr):
    missing_numbers = []
    low, high = 0, len(arr) - 1

    while low < high:
        mid = low + (high - low) // 2
        
        # Expected value at index mid
        expected_value = arr[0] + mid  # Because it's supposed to be a continuous sequence

        if arr[mid] != expected_value:
            # Missing numbers exist on the left side
            high = mid
        else:
            # Move to the right side
            low = mid + 1
    
    # Find all missing numbers from arr[0] to arr[-1]
    for num in range(arr[0], arr[-1] + 1):
        if num not in arr:
            missing_numbers.append(num)

    return missing_numbers

