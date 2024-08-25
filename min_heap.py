#Min Heap Implementation using Array

def minheapify(arr, i, N):
    left = (2 * i) + 1
    right = (2 * i) + 2
    smallest = None
    if (left < N and arr[left] < arr[i]):
        smallest = left
    else: 
        smallest = i
    if (right < N and arr[right] < arr[smallest]):
        smallest = right
    if (smallest != i):
        arr[smallest], arr[i] = arr[i],arr[smallest]
        minheapify(arr, smallest, N)

    
def build_min_heap(arr):
    N = len(arr)

    for i in range(0,(N//2)+1):
        minheapify(arr, i, N)
    return arr

print(build_min_heap([4, 5, 1, 6, 7, 3, 2]))
