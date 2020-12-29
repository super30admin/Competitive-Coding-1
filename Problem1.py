def find_missing(arr):
    l = 0
    r = len(arr) - 1

    #edge cases
    if r < 0 or arr[l] != 1:                    #first element is missing
        return 1
    elif arr[r] - r == 1:                       #nothing is missing
        return arr[r] + 1

    while l + 1 < r:
        mid = l + (r - l) // 2
        if arr[mid] - mid != arr[l] - l:        #missing on left
            r = mid
        elif arr[mid] - mid != arr[r] - r:      #missing on right
            l = mid
    #print(mid)
    return (arr[l] + arr[r]) // 2

print(find_missing([]))
print(find_missing([2, 3]))
print(find_missing([1, 2]))
print(find_missing([1, 2, 3, 5]))
print(find_missing([1, 2, 4, 5]))
print(find_missing([1, 2, 4, 5, 6]))
print(find_missing([1, 2, 3, 4, 5, 6, 8]))