from heapq import heapify, heappush, heappop

heap = []
heapify(heap)

# Adding items using heappush
heappush(heap, 1)
heappush(heap, 5)
heappush(heap, 10)
heappush(heap, 20)

# value of minimum element
print("Head value of heap(Min Eleement) : "+str(heap[0]))

# elements of the heap
print("The heap elements : ")
for i in heap:
	print(i, end = ' ')
print("\n")

element = heappop(heap)

# printing the elements of the heap
print("The heap elements : ")
for i in heap:
	print(i, end = ' ')
print("\n")
