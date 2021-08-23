def binsearch(arr) -> int:
    lo = 0
    hi = len(arr) - 1
    while (hi - lo) > 1:
        mid = (lo + hi) // 2
        if (arr[lo] - lo) == (arr[mid] - mid):
            lo = mid
        elif (arr[hi] - hi) == (arr[mid] - mid):
            hi = mid
    return arr[lo] + 1


a = [1, 2, 3, 5, 6, 7]
    
print('The missing number is '+ str(binsearch(a)))