# Time complexity: O(log(n)), we reduce the search space by half at every step
# Space Complexity : O(1)
# Subtract the value of elements in the array with its index. We will get an array of 1s and 2s. The missing number will be to the immediate left of the first occurence of 2
def find_missing_number(arr):

    n = len(arr)

    l = 0; h = n-1
    new_arr = [arr[i] - i for i in range(n)]
    while l <= h:
        mid = l + (h-l)//2
        # Missing number is to the right of mid
        if new_arr[mid] == 1:
            l = mid + 1
        # Mid is immediately to the right of missing number
        elif new_arr[mid] == 2 and new_arr[mid-1] == 1:
            return mid + 1
        else:
            h = mid - 1
    return l + 1

arr = [2, 3, 4, 5, 6, 7, 8]
missing_number = find_missing_number(arr)
print("Missing number is:", missing_number)

arr = [1, 2, 3, 4, 5, 6, 8]
missing_number = find_missing_number(arr)
print("Missing number is:", missing_number)