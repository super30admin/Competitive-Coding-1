# Time Complexity : O(log n)
# Space Complexity : O(log n)
# Did this code successfully run on Leetcode : NA 
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach : 
# Approach
"""
A heap is created by simply using a list of elements with the heapify function
Used heapq class to implement Heaps in Python. By default Min Heap is implemented by this class.
"""
from heapq import heapify, heappush, heappop 
  
# Creating empty heap 
# Heapify function converts a regular list to a heap. In the resulting heap the smallest element gets pushed to the index position 0. 
# But rest of the data elements are not necessarily sorted.
myheap = [] 
heapify(myheap) 
  
# Adding items to the heap using heappush function 
# heappush adds an element to the heap without altering the current heap.

heappush(myheap, 80) 
heappush(myheap, 90) 
heappush(myheap, 70) 
heappush(myheap, 100) 
  
# printing the value of minimum element 
print("Head value of heap : "+str(myheap[0])) 
  
# printing the elements of the heap 
print("The heap elements : ") 
for i in myheap: 
    print(i, end = ' ') 
print("\n") 
  
element = heappop(myheap) # heappop function returns the smallest data element from the heap.

  
# printing the elements of the heap 
print("The heap elements : ") 
for i in myheap: 
    print(i, end = ' ') 




