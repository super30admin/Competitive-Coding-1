public class Problem2 {
    public static class MinHeap{
        private int[] heap;
        private int size;
        private int max;

        public MinHeap(int max){
            this.max = max;
            this.size = 0;

            this.heap = new int[max+1];
            heap[0] = Integer.MIN_VALUE;
        }

        private int parent(int pos){
            return pos/2;
        }

        private int leftChild(int pos){
            return 2*pos;
        }

        private int rightChild(int pos){
            return (2*pos) +1;
        }

        private boolean isLeaf(int pos){
            if (pos > (size / 2) && pos <= size) {
                return true;
            }return false;
        }

        private void swap(int pos1, int pos2){
            int temp = heap[pos1];
            heap[pos1] = heap[pos2];
            heap[pos2] = temp;
        }

        private void heapify(int pos){
            if(!isLeaf(pos)){
                if((heap[pos] > heap[leftChild(pos)]) || (heap[pos] > heap[rightChild(pos)])){
                    if(heap[leftChild(pos)] < heap[rightChild(pos)]){
                        swap(pos, leftChild(pos));
                        heapify(leftChild(pos));
                    } else {
                        swap(pos, rightChild(pos));
                        heapify(rightChild(pos));
                    }
                }
            }
        }

        private void insert(int element){
            if(size > max){
                return;
            }
            heap[++size] = element;
            int current = size;

            while (heap[current] < heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
        }

        private int getMin(){
            return heap[1];
        }

        private int extractMin(){
            int popped = heap[1];
            heap[1] = heap[size--];
            heapify(1);
            return popped;
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

        System.out.println(minHeap.extractMin()); //3
        System.out.println(minHeap.getMin()); //5
    }
}

