package EnumsAreFun;

import java.util.Arrays;

public class MinHeap {
	int size;
	int[] myHeap;

	MinHeap(int heapSize) {
		myHeap = new int[heapSize];
		for(int i=0;i<myHeap.length;i++) {
			myHeap[i]=-1;
		}
		size = 0;
	}

	public void insert(int element) {
		if (size == 0) {
			myHeap[size] = element;
			size=size+1;
		} else {
			//System.out.println(size);
			int presentIndex=size;
			if(element<myHeap[getParent(presentIndex)]) {
				while (element < myHeap[getParent(presentIndex)]) {
					//System.out.println("hello");
					swap(getParent(presentIndex),element,presentIndex);
					presentIndex=getParent(presentIndex);
					size=size+1;
					
				}
			}else {
				myHeap[presentIndex]=element;
				size=size+1;
			}
		}

	}

	public int getMin() {
		return 1;
	}

	public int extractMin() {
		return 1;
	}

	public int getParent(int index) {
		if (index != 0) {
			return ((index - 1) / 2);
		}
		return 0;
	}

	public int getRightChild(int index) {
		return (2 * index + 2);
	}

	public int getLeftChild(int index) {
		return (2 * index + 1);
	}

	public void printMinHeap() {
		for (int i = 0; i < myHeap.length; i++) {
			if(myHeap[i]==-1) {
				break;
			}
			if(myHeap[getLeftChild(i)]== -1 && myHeap[getRightChild(i)]==-1) {
				break;
			}
			//System.out.println(getLeftChild(i)+","+myHeap[3]);
			System.out.println("PARENT : "+myHeap[i]+ "LEFT CHILD : "+myHeap[getLeftChild(i)]+" RIGHT CHILD : "+myHeap[getRightChild(i)]);
			//System.out.println(myHeap[i]);
		}
	}
	
	public void swap(int parent,int child,int presentIndex) {
		//System.out.println(parent+","+child);
		//System.out.println(Arrays.toString(myHeap));
		int temp=child;
		myHeap[presentIndex]=myHeap[parent];
		myHeap[parent]=child;
		//System.out.println(Arrays.toString(myHeap));
	}
	
	public void remove() {
		System.out.println(myHeap[0]+" is removed from the heap");
		System.out.println(myHeap[size-1]);
		myHeap[0]=myHeap[size-1];
		myHeap[size-1]=-1;
		size=size-1;
		int parent=myHeap[0];
		int index=0;
		int tempIndex=0;
		int minFromTwo=0;
		while(parent>myHeap[getRightChild(index)] || parent>myHeap[getLeftChild(index)]) {
			minFromTwo=Math.min(myHeap[getRightChild(index)], myHeap[getLeftChild(index)]);
			if(myHeap[getRightChild(index)]<myHeap[getLeftChild(index)]) {
				minFromTwo=myHeap[getRightChild(index)];
				tempIndex=getRightChild(index);
			}else {
				minFromTwo=myHeap[getLeftChild(index)];
				tempIndex=getLeftChild(index);
			}
			if(minFromTwo==-1) {
				break;
			}
			//System.out.println(Arrays.toString(myHeap));
			//System.out.println();
			myHeap[index]=minFromTwo;
			myHeap[tempIndex]=parent;
			index=tempIndex;
			parent=myHeap[index];
			//System.out.println(parent+", "+index);

		}
		
	}

	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(15);
		minHeap.insert(5); 
        minHeap.insert(3); 
        minHeap.insert(17); 
        minHeap.insert(10); 
        minHeap.insert(84); 
        minHeap.insert(19); 
        minHeap.insert(6); 
        minHeap.insert(22); 
        minHeap.insert(9); 
        minHeap.printMinHeap();
        //System.out.println(Arrays.toString(minHeap.myHeap));
        minHeap.remove();
        minHeap.printMinHeap();
        
       // minHeap.printMinHeap();
	}

}


//The Output is
PARENT : 3LEFT CHILD : 5 RIGHT CHILD : 6
PARENT : 5LEFT CHILD : 9 RIGHT CHILD : 84
PARENT : 6LEFT CHILD : 19 RIGHT CHILD : 17
PARENT : 9LEFT CHILD : 22 RIGHT CHILD : 10
3 is removed from the heap
10
PARENT : 5LEFT CHILD : 9 RIGHT CHILD : 6
PARENT : 9LEFT CHILD : 10 RIGHT CHILD : 84
PARENT : 6LEFT CHILD : 19 RIGHT CHILD : 17
PARENT : 10LEFT CHILD : 22 RIGHT CHILD : -1
