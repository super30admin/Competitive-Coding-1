# Time Complexity=O(log n)
# Time Complexity=O(1)

def missing(arr):
    i=0
    size=len(arr)
    while i+1<size:
        size2=(i+size)//2
        if arr[size2]-size2 != arr[i]-i:
            size=size2
        else:
            i=size2
    return arr[i]+1
arr = [1, 2, 4, 5, 6, 7, 8, 9]
c=missing(arr)
