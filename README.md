# Competitive-Coding-1

Please submit the interview problems posted in slack channel here. The problems and statements are intentionally not shown here so that students are not able to see them in advance 

1. Find Missing Number in a sorted array
In this what I did is checked middle element if it is equal to mid + 1 then left side of array has all the element and we will adjust the pointer and search in right side. If it is not then the missing element is in left side. This way we can apply binary search here and complete the whole logic in log n time complexity. In the left side we can check if the middle element is mid + 2. If it is then we have found the missing element. The missing element then would be mid + 1. If that is not the case then we will adjust high index and search in the left side of an array.


2. Implementation of MinHeap using array
Functions - 

parent - pos / 2
leftchild - pos * 2
rightchild - pos * 2 + 1
isLeaf - if node has pos > (size / 2) && pos <= size all the nodes in this range are leaf node.
size - returned size.
print - iterated through heap array and printed all the elements.
peek - root node will always be stored at 1st index - so heap[1] will always show peek.
swap - swap 2 elements at given position pos1 and pos2.
minHeapify - In this we will maintain heap property. First will check if the current node is leaf, if it is not then will compare it's value with values of left and right children. Will swap the root with child to maintain heap property. 
add - First will check for capacity if there is space to add in the heap. If there is space first will the size of heap by one and will place new element at the end of the heap. Then apply above heapify function to maintain the heap.
remove - First will store first element in a variable. Then will move the last element to root position, then size of heap is decreased by one and again apply heapify function to restore heap property. Then we can return store variable at the end.