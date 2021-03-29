/**Min Heap Design Implementation 
 * A Min-Heap is a complete binary tree in which the value in each internal node is less than or equal to the values in the children of that node.
Mapping the elements of a heap into an array is trivial: if a node is stored a index k, then its left child is stored at index 2k + 1 and its right child at index 2k + 2.

Operations on Min Heap:

getMin(): It returns the root element of Min Heap. O(1)
extractMin(): Removes the minimum element from MinHeap. O(log N) as this operation needs to maintain the heap property after removing root.
insert(): We add a new key at the end of the tree. If new key is larger than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property. O(log N)
Example of Min Heap:

         5                      11





         /      \               /       \  





       9        13           13         25 





      /                      /  \        /  \





    20                     32    45    95    40
*/
/**Algorithm
 * 1. getMin() - The root element is the minimum element so return that.
 * 2. extractMin() - delete the element at the start of the array and 
 */