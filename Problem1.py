// T.C = log(n)
def missing_num(arr):
    low = 0
    high = len(arr) - 1


    while(low<=high):
        mid = low + (high - low)//2

        if(arr[mid] != (mid + 1)):
            high = mid - 1
        else:
            low = mid + 1
    return low + 1

arr = [1,2,3,4,6,7,8]
missing = missing_num(arr)
print(missing)
