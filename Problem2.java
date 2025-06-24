private static class MinHeap {
//minHeap can be an array with element always less that 2*index+1 or 2*index+2
        int[] heap;
        int size;
        int maxSize;
        MinHeap(){
            this.size = 0;
            this.maxSize = 100;
            heap = new int[maxSize];
        }
        //Parent element
        int getParent(int index){
            return (index-1)/2;
        }
        
        //getting left node
        int getLeft(int index){
            return (2*index)+1;
        }
        
        //getting right node
        int getRight(int index){
            return (2*index)+2;
        }
        
        //if heap is empty, return 0 or return 1st element as it is minheap
        int getMin(){
            if(size == 0){
                return 0;
            }
            return heap[0];
        }
        
        void insert(int key){
            if(maxSize == size){
                System.out.println("Heap size full");
                return;
            }
            //if the size is full, return or inserting at the end
            heap[size] = key;
            size++;
            int i = size - 1;
            //As the child node should be maximun that parent, going from leaf node, swapping if the condition is not met 
            while(i > 0 && heap[i] < heap[getParent(i)]){
                    swap(i, getParent(i));
                    i = getParent(i);
            }
        }
        void swap(int i,int j){
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
        
        int extractMin(){
            if(size == 0){
                return 0;
            }
            int min = heap[0];
            heap[0] = heap[size-1];   //making last element as root
            size--;
            heapify(0);      //traversing to meet conditions for min heap
            return min;
        }
        
        //After removing min, the heap will not be minHeap so going through root node, checking if parent node is greater than swapping
        void heapify(int key){
            int parent = key;
            int left = getLeft(key);
            int right = getRight(key);
            if(left<size && heap[left] < heap[parent]){
                parent = left;
            }
            if(right<size && heap[right] < heap[parent]){
                parent = right;
            }
            if(key != parent){
                swap(key, parent);
                //after swapping calling fuction from the smallest element
                heapify(parent);
            }
        }
    }
