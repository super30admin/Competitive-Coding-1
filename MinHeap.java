/*Time Complexity: O(n) for inserting since we are doing the arraycopy, O(1) for getting the minimum and of course rearranging takes O(log n)
 * Space Complexity: O(1)
 * Leetcode: n/a
 * any problems : yes, regarding space complexity analysis, need to discuss in class.
 */
public class MinHeap<T extends Comparable<T>> {

    private T[] minHeap;
    private int position;

    public MinHeap()
    {
        minHeap = (T[]) new Comparable[2];
        position = -1;
    }
    
    private void resize(int capacity){
            System.arraycopy(minHeap, 0, minHeap = (T[]) new Comparable[capacity], 0, position+1);
    }

    private void swap(int i, int pi)
    {
        T temp = minHeap[i];
        minHeap[i] = minHeap[pi];
        minHeap[pi] = temp;
    }

    private void upHeapify(int position)
    {
        if(position == 0) return;
        int index = position;
        
        while(index>0)
        {
            int parentIndex = (index-1)/2;
            //check the current element with the parent element, if the element is lesser then swap them, 
            //repeat it till index becomes 0 or if the parent is lesser than the element.
            if(minHeap[index].compareTo(minHeap[parentIndex])<0)
            {
                swap(index, parentIndex);
                index = parentIndex;
            }
            else
            break;
        }
        return;
    }

    //Insertion into minheap
    public void insert(T num){
        //is the heap is full then we need to resize the array 
        if(minHeap.length-1 == position)
            resize(minHeap.length*2);
        //insert the new element at the end and perform upheapify to put the element in the right level of the heap
        minHeap[++position] = num;
        upHeapify(position);
    }

    private void downHeapify(int position)
    {
        //is there are no elements after removing the top then just return
        if(position == -1) return;
        //start from the root
        int index = 0;
        /*1) check if left child exists if yes 
         * 2)then check if right child exists if yes 
         * 3)them compare both the children and note down which is lesser
         * 4) now compare the parent with the smaller child, if child is small then swap both, if not just return.
         * 5)perform this till no parent is greater than its child.
         */
        while(index <= position)
        {
            int leftIndex = 2*index+1;
            int rightIndex = 2*index+2;

            if(leftIndex > position) return;

            int childToSwap = rightIndex > position ? leftIndex 
            : minHeap[leftIndex].compareTo(minHeap[rightIndex]) < 0 ? leftIndex : rightIndex;

            if(minHeap[index].compareTo(minHeap[childToSwap])>0)
            swap(index, childToSwap);
            index = childToSwap;
        }
    }
    public T getMin()
    {
        //always in minheap the minimum element will be at the front.
        T min = minHeap[0];
        //as we need to fix the heap again after removing the minimum, 
        //for the time being put the last element at the root and delete the last node.
        minHeap[0] = minHeap[position--];
        //perform downHeapify to fix the heap structure.
        downHeapify(position);
        return min;
    }
    public void display()
    {
    	int index = 0;
    	while(index<=position)
    	{
    		System.out.print( minHeap[index]);
    		index++;
    	}
    	System.out.println();
    }
    public static void main(String[] args)
    {
        Integer[] arr = new Integer[]{5, 8, 2, 4, 9, 10, 1, 3, 11};
        MinHeap<Integer> heap = new MinHeap<>();
        for(int i=0; i<arr.length; i++)
            heap.insert(arr[i]);
        heap.display();;
        System.out.println(heap.getMin());
        System.out.println(heap.getMin());
        System.out.println(heap.getMin());
        System.out.println(heap.getMin());
        heap.display();
    }

}