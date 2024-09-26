# implement min heap data structure 

#Time complexity : insert : 0(logn)
# extract_min : 0(logn) : need to call heapify after returing root
#get_min : 0(1)
#space complexity : number of elements in the heap 

#using inbuilt libraries

from heapq import heappush, heappop

heap = []

heappush(heap,10)
heappush(heap,20)
heappush(heap,300)
heappush(heap,1)
heappush(heap,900)

element = heappop(heap)
element1 = heappop(heap)

heappush(heap,0)
element2 = heappop(heap)
print(element)
print(element1)
print(element2)