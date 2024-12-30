
def missingNumber(arr,n):
    # TC: O(log n)
    # SC: O(1)
    
    if len(arr) == 0:
        return -1
    l, r = 0, len(arr) - 1
    while l < r:
        m = l + (r - l) // 2
        # compare the relative position of mid element and traverse to corresponding side
        if arr[m] - m != arr[0]:
            r = m
        else:
            l = m + 1
    if arr[0]+l == n:
        return -1
    return arr[0] + l