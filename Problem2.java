
public class Problem2 {
    public class Heap{
        int[] heap;
        int capacity;
        int size;

        Heap{
            size = 0;
            capacity = 10;
            heap = new int[capacity];
            heap[size]=Math.min;
        }

        //T.c - 0(1)
        public int findParentIndex(int index){
            return index/2;
        }
        //T.c - 0(1)
        public int leftChildIndex(int index){
            return index*2;
        }
        //T.c - 0(1)
        public int rightChildIndex(int index){
            return index*2+1;
        }
        //T.c - 0(1)
        public boolean isLeafNode(int index){
            return size/2 < index;
        }
        //T.c - 0(1)
        public int size(){
            return size;
        }
        //T.c - 0(1)
        public int peek(){
            return heap[1];
        }

        public void swap(int fPos, int sPos){
            int temp = heap[fPos];
            heap[fPos] = heap[sPos];
            heap[sPos] = temp;
        }
        //T.c - 0(logN) -> we're going from bottom to top
        public void add(int element){
            if(size>= capacity){
                System.out.println("No space, can't add any more element");
                return;
            }
            size++;
            heap[size] = element;
            int currIndex = size;

            //check if the current index element is smaller than its parent index element;
            while(heap[currIndex] < heap[findParentIndex(curr)]){
                //swap them
                swap(currIndex, findParentIndex(currIndex));
                // change the current to parent index;
                currIndex = findParentIndex(currIndex);
            }
        }
        //T.c - 0(logN)-> we're going from top to bottom
        public void heapiFy(int index){
            if(!isLeafNode(index)){//we should not be at the leaf
                // check if the left child or right clild is smaller
                if(heap[index]>heap[leftChildIndex(index)] ||  heap[index] > heap[rightChildIndex(index)]){
                    //if right is smaller
                    if(heap[rightChildIndex(index)]<heap[index]){
                        //swap
                        swap(index,rightChildIndex(index));
                        //change the current index
                        index = rightChildIndex(index);
                        //recursive call
                        heapiFy(index);
                    }
                    else{
                        swap(index,leftChildIndex(index));
                        index = leftChildIndex(index);
                        heapiFy(index);
                    }
                }
            }
        }
        //T.c - 0(logN)
        public int remove(){
            int removedElement = heap[1];
            heap[1] =  heap[size];
            size--;
            heapiFy(1);

            return removedElement;
        }

    }
    public static void main(String[] args) {
        Heap minHeap = new Heap();
        System.out.println("Min Heap Impl : ");
    }
}