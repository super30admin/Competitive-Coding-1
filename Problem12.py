# Assumption is all te values in the array are > 0 and ordered value with one missing value

def bst(arr):
    low = 0
    high = len(arr)-1

    while high - low > 1:
        mid = (low + high) // 2
        if arr[mid]-mid > 1:
            high = mid

        elif arr[high]-high > 1:
            low = mid

        else:
            print("")
    if len(arr)>1:
        if arr[high]-high > 1:
            return arr[high]-1
    else:
        return None

input_arr = [1,2,4] #[1] [5] [1,3,4,5,6,7] [1,2,3,4,5,6,7,9] [1,2,3,4,5,7,8]
print(bst(input_arr))