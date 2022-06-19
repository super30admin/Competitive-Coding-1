
 
def search(ar, size):
   # Extreme cases
    if(ar[0] != 1):
        return 1
    if(ar[size-1] != (size+1)):
        return size+1
 
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
 
 
# Driver Code
a = [1, 2, 3, 4, 5, 6, 8]
n = len(a)
 
print("Missing number:", search(a, n))
 

 