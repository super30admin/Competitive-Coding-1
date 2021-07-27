def search(ar, size):
    a = 0
    b = size - 1
    mid = 0
    while b > a + 1:
        mid = (a + b) // 2
        if (ar[a] - a) != (ar[mid] - mid):
            b = mid
        elif (ar[b] - b) != (ar[mid] - mid):
            a = mid
    return ar[a] + 1
 

a = [1, 2, 3, 4, 5, 7, 8]
n = len(a)
 
print("Missing number:", search(a, n))
