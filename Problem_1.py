'''
    Given an array of contiguous integers of size N-1, where the elements of the array could be anywhere in the range [1,N], find the missing element in the array

    Example 1:
        Input = [2,3,4,5,6,7,9,10]
        Output = 8

    Example 2:
        Input = [2,3,5,6,7,9,10]
        Output = 4

    Example 3:
        Input = [2]
        Output = -1
'''
def search_missing(A):

    N = len(A)
    if N <= 1:
        return -1
    if A[1] != A[0] + 1:
        return A[0] + 1
    if A[N-1] != A[N-2] + 1:
        return A[N-2] + 1

    s=1
    e=N-2
    while s <= e:
        mid = s + (e - s)//2
        if (A[mid] + 1) != A[mid+1]:
            return A[mid] + 1
        if A[s] - s == A[mid]-mid: # left half is continguous
            s = mid + 1
        else: # right half is contiguous
            e = mid - 1

A = [2,3,4,5,6,7,9,10]
print(search_missing(A))

A = [2,3,5,6,7,9,10]
print(search_missing(A))

A = [2]
print(search_missing(A))