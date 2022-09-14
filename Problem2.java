
// "static void main" must be defined in a public class.
import java.util.*;
public class Heap {
    static ArrayList<Integer> minHeap;
    Heap()
    {
        minHeap=new ArrayList<Integer>();
    }

    private static int leftChild(int index)
    {
    	return 2*index;

    }

    private static int rightChild(int index)
    {
    	return 2*index+1;
    	
    }

    private static int parent(int index)
    {
    	return (index-1)/2;
    }

    private static void swap(int i,int j)
    {
    	int temp=minHeap.get(i);
    	minHeap.set(i,minHeap.get(j));
    	minHeap.set(j,temp);
    }

    private static void bubbleUp(int index)
    {
    	if(index==0) return;
    	int parent=parent(index);
    	if(minHeap.get(index)<minHeap.get(parent))
    	{
    		swap(index,parent);
    		bubbleUp(parent);
    	}

    }

    private static void bubbleDown(int index)
    {
    	if(getSize()==1) return;

    	int leftChild=leftChild(index);
    	int rightChild=rightChild(index);
    	int temp=index;
    	if(leftChild<getSize() && minHeap.get(leftChild)<minHeap.get(temp))
    		temp=leftChild;
    	if(rightChild<getSize() && minHeap.get(rightChild)<minHeap.get(temp))
    		temp=rightChild;

    	if(temp==index)
    		return;

    	swap(temp,index);
    	bubbleDown(temp);
    }

    private static void printHeap()
    {
        if(getSize()==0) System.out.println("Empty list");
    	for (int i = 0; i < minHeap.size(); i++) 
      		System.out.print(minHeap.get(i)+" ");
      	System.out.println();
    }

    public static int getMin()
    {
        if(getSize()==0) return -1;
    	return minHeap.get(0);
    }

    public static int getSize()   {

    	return minHeap.size();
    	
    }

    public static void insert(int num){

    	int n=minHeap.size();
    	minHeap.add(num);

    	if(n==0) return;

    	bubbleUp(n);


    }
    
    public static void remove()
    {
    	int n=minHeap.size()-1;
    	int min=getMin();
        minHeap.set(0,minHeap.get(n));
        minHeap.remove(n);

        bubbleDown(0);

    }

    public static void main(String[] args)
    {
    	Heap heap=new Heap();
    	int[] arr=new int[]{9,8,7,5,4,3,2,1};
    	for(int i=0;i<arr.length;i++)
    	{
    		Heap.insert(arr[i]);
    		printHeap();
    		System.out.println("------------------ min = "+getMin());


    	}

    	for(int i=0;i<arr.length;i++)
    	{
    	    System.out.println("------------------ min = "+getMin());
    		Heap.remove();
    		printHeap();
    		


    	}

    }

}