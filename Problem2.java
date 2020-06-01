// Time Complexity : FindMin is O(1), Insert is O(log n), deleteMin is O(log n) where n is number of elements in heap
// Space Complexity :O(n) where n is number of elements inserted in heap
// Did this code successfully run on Leetcode : Not on leetcode
// Any problem you faced while coding this : No

public class MinHeap {
	
	class EmptyHeapException extends Exception{  
		EmptyHeapException(String s){  
		  super(s);  
		 }  
		}  
	
	int currentSize;
	int[] array;
	int size;
	public MinHeap()
	{
		 array = new int[10];
	}
	
	private void enlargeArray(int size)
	{
		int[] enlargedArr = new int[size];
		for(int i=0;i<array.length;i++)
		{
			enlargedArr[i] = array[i];
		}
		array = enlargedArr;
	}
	
	public void insert( int x )
    {
        if( currentSize == array.length - 1 )
            enlargeArray( array.length * 2 + 1 );

            // Percolate up
        int hole = ++currentSize;
        for(array[0]=x; x < ( array[ hole / 2 ] ) ; hole /= 2 )
            array[ hole ] = array[ hole / 2 ];
        array[ hole ] = x;
        System.out.println("Inserted "+x);
    }
	
	public int deleteMin() throws Exception
    {
        if( isEmpty( ) )
            throw new EmptyHeapException("Heap is empty!");
        else
        {
        int minItem = findMin( );
        array[ 1 ] = array[ currentSize-- ];
        percolateDown( 1 );
        return minItem;
        }
    }
	
	private int findMin() throws Exception
	{
		if(currentSize==0)
			throw new EmptyHeapException("Heap is empty!"); 
		return array[1];
		
	}
	
	private void percolateDown(int hole)
	{
		int child;
        int tmp = array[ hole ];     // save the value to percolate down

        for( ; hole * 2 <= currentSize; hole = child )  // go down level by level
        {
            child = hole * 2;    // left child
            if( child != currentSize &&
                    array[ child + 1 ] < ( array[ child ] )  )
                child++;  // if right child exists and is less than left child, use right child
            if( array[ child ] <  tmp  )  // if tmp > child, slide child up
                array[ hole ] = array[ child ];
            else
                break;   // found proper position
        }
        array[ hole ] = tmp;   // put the “extra” value into the empty node
	}
	
	private boolean isEmpty()
	{
		return currentSize==0;
	}

public static void main(String[] args) throws Exception {
	MinHeap heap = new MinHeap();
	heap.insert(15);
	heap.insert(1);
	heap.insert(38);
	heap.insert(4);
	heap.insert(0);
	
	System.out.println("Minimum is " +heap.findMin());
	System.out.println("Deleting minimum "+heap.deleteMin());
	
	System.out.println("Minimum is " +heap.findMin());
	System.out.println("Deleting minimum "+heap.deleteMin());
	
	System.out.println("Minimum is " +heap.findMin());
	System.out.println("Deleting minimum "+heap.deleteMin());
	
	
	System.out.println("Minimum is "+heap.findMin());
}

}
