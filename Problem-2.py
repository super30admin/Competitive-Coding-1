#Time Complexity : O(N)
#Space Complexity : O(N)

# Function to heapify a subtree rooted at given index
def heapify(arr, n, i):
    smallest = i
    l = 2 * i + 1
    r = 2 * i + 2

    # Check if left child is smaller than root
    if l < n and arr[l] < arr[smallest]:
        smallest = l

    # Check if right child is smaller than smallest so far
    if r < n and arr[r] < arr[smallest]:
        smallest = r

    # If smallest is not root
    if smallest != i:
        arr[i], arr[smallest] = arr[smallest], arr[i]  # Swap
        heapify(arr, n, smallest)

# Function to build a heap
def buildHeap(arr):
    n = len(arr)
    # Start from the last non-leaf node and heapify
    for i in range(n, -1, -1):
        heapify(arr, n, i)

# Sample array
arr = [1, 5, 6, 8, 9, 7, 3]

print("Array representation before buildHeap is:")
print(*arr)

# Call buildHeap function
buildHeap(arr)

print("Array representation after buildHeap is:")
print(*arr)
