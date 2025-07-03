import java.util.ArrayList;

class Problem2 {
    class MinHeap{
        private ArrayList<Integer> heap;

        public MinHeap(){
            heap = new ArrayList<>();
        }
        
        private int parent(int i){
            return (i-1)/2;
        }
        private int left(int i){
            return 2*i+1;
        }
        private int right(int i){
            return 2*i+2;
        }

        private void swap(int i, int j){
            int tmp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, tmp);
        }

        public void insert(int val){
            heap.add(val);
            int i = heap.size()-1;
            while (i>0 && heap.get(parent(i))> heap.get(i)) {
                swap(i, parent(i));
                i=parent(i);
                
            }

        }

        public int getMin(){
            if(heap.isEmpty()){
                throw new IllegalStateException("Heap is Empty");
            }
            return heap.get(0);
        }

        public int extractMin() {
            if(heap.isEmpty()){
                throw new IllegalStateException("Heap is Empty");
            }
            int min = heap.get(0);
            int last = heap.remove(heap.size()-1);
            if(!heap.isEmpty()){
                heap.set(0, last);
                heapify(0);
            }
            return min;
        }

        private void heapify(int i){
            int smallest = i;
            int left = left(i);
            int right = right(i);

            if(left<heap.size() && heap.get(left) < heap.get(smallest)){
                smallest = left;
            }
            if(right < heap.size() && heap.get(right) < heap.get(smallest)){
                smallest = right;
            }

            if(smallest!=i){
                swap(i, smallest);
                heapify(smallest);
            }
        }


        public void printHeap(){
            System.out.println(heap);
        }
        public boolean isEmpty() {
            return heap.isEmpty();
        }
    }

    public static void main(String[]args){
        Problem2 ob = new Problem2();
        MinHeap heap = ob.new MinHeap();

        heap.insert(20);
        heap.insert(5);
        heap.insert(15);
        heap.insert(22);
        heap.insert(3);
        heap.printHeap();
        System.out.println("Min: "+ heap.getMin());
        System.out.println("Extracted Min: "+ heap.extractMin());
        heap.printHeap();
    }

}