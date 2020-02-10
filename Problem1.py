# A binary search based program to find
# the only missing number in a sorted
# in a sorted array of distinct elements
# within limited range
def search(ar, size):
    l, r = 0, size - 1
    while l <= r:
        mid = l + (r - l) // 2
        if ar[0] + mid == ar[mid]:
            l = mid + 1
        elif ar[0] + mid != ar[mid]:
            r = mid - 1

    return ar[r] + 1


# Driver Code
a = [2, 3, 4, 5, 7]
n = len(a)

print("Missing number:", search(a, n))
