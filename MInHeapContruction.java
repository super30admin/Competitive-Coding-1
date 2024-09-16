import java.util.*;

//
class Program {
  static class MinHeap {
    List<Integer> heap = new ArrayList<Integer>();

    public MinHeap(List<Integer> array) {
      heap = buildHeap(array);
    }

    public List<Integer> buildHeap(List<Integer> array) {
      int firstParentIdx = (array.size()-2)/2;
			for ( int currentIdx =firstParentIdx; currentIdx>=0;currentIdx--){
				siftDown(currentIdx,array.size()-1,array);
			}
      return array;
    }
		// O(n) time | O(1) space
    public  void siftDown(int currentIdx,int endIdx,List<Integer> heap){
		int childOneIdx= currentIdx * 2 + 1;
		while(childOneIdx<=endIdx ){
			int childTwoidx= currentIdx*2+2<=endIdx? currentIdx*2+2:-1;
			int idxToswap;
			if (childTwoidx!=-1 && heap.get(childTwoidx)<heap.get(childOneIdx)){
				idxToswap= childTwoidx;
			}else{
				idxToswap= childOneIdx;
			}if (heap.get(idxToswap)< heap.get(currentIdx)){
				swap(currentIdx,idxToswap,heap);
				currentIdx=idxToswap;
				childOneIdx= currentIdx*2+1;
			}else{
				return;
			}
		}
	}
		
		// O(log(n)) time | 0(1) space
    public void siftUp(int currentIdx, List<Integer> heap) {
   		int parentIdx= (currentIdx-1)/2;
			
			while(currentIdx>0 && heap.get(currentIdx)<heap.get(parentIdx)){
				swap(currentIdx,parentIdx,heap);
				currentIdx=parentIdx;
				parentIdx= (currentIdx-1)/2;
				
			}
    }

    public int peek() {

      return heap.get(0);
    }

    public int remove() {
		swap(0,heap.size()-1,heap);
			int valueToremove= heap.get(heap.size()-1);
			heap.remove(heap.size()-1);
			siftDown(0,heap.size()-1,heap);
      return valueToremove;
    }

    public void insert(int value) {		
			heap.add(value);
			siftUp(heap.size()-1, heap);
    }
		
		public void swap(int i , int j , List<Integer> heap){
			Integer temp =  heap.get(j);
			heap.set(j, heap.get(i));
			heap.set(i,temp);
			
		}
  }
}
