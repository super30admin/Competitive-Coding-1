def Missing_Number(arr):
    low = 0
    high = len(arr) - 1 
    while low <= high:
        mid = low + (high - low) // 2
        if (arr[mid] - mid) - (arr[low] - low) > 0:
            high = mid - 1
        elif (arr[mid] - mid) - (arr[low] - low) == 0:
            low = mid + 1

    return low + arr[0]

array = [1, 2, 3, 5, 6, 7, 8]
missing_number = Missing_Number(array)
print(f"The missing number is: {missing_number}")