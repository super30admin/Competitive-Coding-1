def FindMissingNumber(ar):
    n = len(ar) 
    if(ar[0] != 1):
        return 1
        
    if ar[n-1] != n+1:
        return n+1
        
    low = 0
    high = n-1
    while low <= high:
        mid = low + (high-low)//2
        if ar[mid] + 1 != ar[mid+1]:
            return ar[mid] + 1

        elif ar[mid] - mid != 1:
            high = mid - 1
        else:
            low = mid + 1

    return -1

if __name__ == "__main__":

    n = int(input("len of arr: "))
    ar = []
    for i in range(n):
        num = int(input())
        ar.append(num)
    print(ar)
    ans = FindMissingNumber(ar)
    print(ans)
    