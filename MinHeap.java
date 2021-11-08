import java.util.ArrayList;
import java.util.List;

public class MinHeap{

	    List<Integer> arr=new ArrayList<>();
		
		public int parent(int pos) {
			return 1;
		}
		
		public int left(int pos) {
			int left=2*(pos)+1;
			if(left>=arr.size())return Integer.MAX_VALUE;
			return left;
		}
		
		public int right(int pos) {
			int left=2*(pos)+2;
			if(left>=arr.size())return Integer.MAX_VALUE;
			return left;
		}
		
		public int getMin() {
			return arr.get(0);
		}
		
		public int removeMin() {
			int min=arr.get(0);;
			int last=arr.get(arr.size()-1);
			arr.set(0, last);
			arr.remove(arr.size()-1);
			minHeapify(0);
			return min;
		}
		
		public void insert(int val) {
			arr.add(val);
			minHeapify(0);
		}
		
		public void swap(int i, int j) {
			int temp=arr.get(i);
			arr.set(i,arr.get(j));
			arr.set(j, temp);
		}
		
		public void minHeapify(int i) {
			
			if(i>=arr.size()) {
				return;
			}
			int leftPos=left(i);
			int rightPos=right(i);
				int node=arr.get(i);

				if(leftPos<arr.size() && rightPos<arr.size()) {
					int leftNode=arr.get(leftPos);
					int rightNode=arr.get(rightPos);
					if(node>leftNode && node>rightNode){
						if(leftNode>=rightNode) {
							swap(i,rightPos);
							minHeapify(rightPos);
						}else {
							swap(i,leftPos);
							minHeapify(leftPos);
						}
					}else if(node>leftNode && node<rightNode) {
						swap(i,leftPos);
						minHeapify(leftPos);
					}else if(node<leftNode && node>rightNode) {
						swap(i, rightPos);
						minHeapify(rightPos);
					}
				}else if(leftPos<arr.size()) {
					int leftNode=arr.get(leftPos);
			
					if(node>leftNode) {
						swap(i,leftPos);
						minHeapify(leftPos);
					}
				}else if(rightPos<arr.size()) {
					int rightNode=arr.get(rightPos);
					
					if(node>rightNode) {
						swap(i,rightPos);
						minHeapify(rightPos);
					}
				}
				minHeapify(i+1);
				
		}
		
		public void print(){
		    for(int i:arr){
		        System.out.print(i+" ");
		    }
		    System.out.println();
		}
	    
	    
		
	    public static void main(String args[]) {
	        MinHeap minheap=new MinHeap();
	        
			minheap.insert(5);
			minheap.insert(19);
			minheap.insert(22);
			minheap.insert(6);
			minheap.insert(2);
			System.out.println(minheap.removeMin());
			System.out.println(minheap.removeMin());
			System.out.println(minheap.removeMin());
			System.out.println(minheap.removeMin());
			minheap.insert(1);
			
	    }
	}
	

