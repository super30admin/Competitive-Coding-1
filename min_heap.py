def find_missing(arr):
    # if len(arr) == 1:
    #     if arr[0] == 2:
    #         return 1
    l, r = 0, len(arr)-1

    while l <= r:
        m = (l+r)//2
        if (arr[m] - m == 1) and (arr[m+1] - (m+1) > 1):
            # current at right place, next is escalated = next missing
            return m+2
        if (arr[m] - m > 1) and (m == 0 or arr[m-1] - (m-1) == 1):
            # current at wrong place but previous is right = current missing
            return m+1
        if arr[m] - m == 1:
            # everything till now is where it's supposed to be, hence search right half
            l = m + 1
        else:
            # we missed something on our way here - search left half
            r = m - 1

print(find_missing([1, 2, 3, 5, 6, 7])) # exp = 4

print(find_missing([2, 3, 4, 5, 6, 7])) # exp = 1

print(find_missing([1, 3])) # exp = 2

print(find_missing([2])) # exp = 1

print(find_missing([1, 2, 4])) # exp = 3
