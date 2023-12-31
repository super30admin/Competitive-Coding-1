# Heapifying
def heapify(arr, length, i):
    smallest = i
    left = 2 * i + 1
    right = 2 * i + 2

    if left < length and arr[left]< arr[smallest]:
        smallest = left
    
    if right < length and arr[right] < arr[smallest]:
        smallest = right

    if smallest != i:
        arr[i], arr[smallest] = arr[smallest], arr[i]
        heapify(arr, length, smallest)

def build_heap(arr):
    length = len(arr)
    for i in range(length//2-1, -1, -1):
        heapify(arr, length, i)

# Returning the root element
def getMin(heap):
    return heap[0]

# Removing the root element
def extractMin(heap):
    heap[0], heap[-1] = heap[-1], heap[0]
    min = heap.pop()
    build_heap(heap)
    return min

# Inserting an element
def insert(heap, new_item):
    heap.append(new_item)

    build_heap(heap)


arr = [5,17,3,10,84,19,6,22,9]
# arr = [10, 9, 5, 17, 84, 19, 6, 22]


print(arr)
build_heap(arr)
print(arr)
print(getMin(arr))
print(extractMin(arr))
print(arr)
insert(arr, 1)
print(arr)

