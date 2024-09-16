# Time Complexity: O(log(n))
# Space Complexity: O(1)

def find_missing(arr, n):
    l = 0
    h = n - 1

    # If no element is missing
    if arr[h] - arr[l] == h - l:
        return -1
        
    while l <= h:
        mid = l + (h - l) // 2
        
        # If the missing element is just behind the mid element
        if mid > 0 and arr[mid] - arr[mid - 1] != 1:
            return arr[mid] - 1
        
        # If the missing element is just after the mid element
        if mid < n - 1 and arr[mid + 1] - arr[mid] != 1:
            return arr[mid] + 1
        
        # If missing element is towards the left side of mid
        if arr[mid] - arr[0] != mid - 0:
            h = mid - 1

        # If missing element is towards the right side of mid
        elif arr[n - 1] - arr[mid] != n - 1 - mid:
            l = mid + 1

    return -1

arr = [1,2,3,4,6,7,8]
print(find_missing(arr, len(arr)))