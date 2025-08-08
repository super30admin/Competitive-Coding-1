#Find Missing Number in a sorted array
#We are comparing the index with the value at that index and using binary search to identify the missing number.
def find_missing_number(arr):
    l,h= 0, len(arr) - 1
    while l<=h:
        mid = (l+h)//2
        if arr[mid]-1 == mid:
            l = mid +1
        else:
            h = mid-1
    return l+1

arr = [1, 2, 3, 4, 5, 6, 8]
print(find_missing_number(arr))
        