#We calculate the difference between the number and the index and compare with the difference for the first element. If both are different then the missing number is in that half
#Time: O(logn), since we are using binary search
#Space: O(1)
#Yes it worked in GFG

def search(ar, size):
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