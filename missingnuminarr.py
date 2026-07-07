def search(ar):
    a = 0
    b = len(ar) - 1

    while (b - a) > 1:
        mid = (a + b) // 2
        if (ar[a] - a) != (ar[mid] - mid):
            b = mid
        elif (ar[b] - b) != (ar[mid] - mid):
            a = mid

    return ar[a] + 1

# Driver code
ar = [1, 2, 3, 4, 7, 6, 8]
print("Missing number:", search(ar))

# TC - O(logn)
# SC - O(1)