class Problem2 {

    int[] arr;
    int heap_size = 0;
    Problem2(int size) {
        arr = new int[size];
    }
    int parent(int pos) {
        return (pos-1)/2;
    }
    int leftChild(int pos) {
        return pos*2 + 1;
    }
    int rightChild(int pos) {
        return pos*2 + 2;
    }
    int getMin() {
        return arr[0];
    }
    int size() {
        return heap_size+1;
    }

    void MinHeapify(int pos) {
        int smallest = pos;
        int left = leftChild(pos);
        int right = rightChild(pos);
        if (left <= heap_size && arr[left] < arr[pos]) {
                smallest = left;
        }
        else
                smallest = pos;
        if (right <= heap_size && arr[right] < arr[smallest]) {
                smallest = right;
        }        
        else
                smallest = pos;

        if (smallest != pos) {
            swap(pos,smallest);
            MinHeapify(smallest);

        }        
    }

    void insertKey(int val) {
        
        arr[heap_size++] = val;
        int i = heap_size - 1;
        while ( i!=0 && arr[parent(i)] > arr[i]) {
            swap(i,parent(i));
            i = parent(i);
        }
    }
    int extractMin() {
        if (heap_size == 0)
            return Integer.MAX_VALUE;
        if (heap_size == 1)
            return arr[0];    
        int smallest = arr[0];
        arr[0] = arr[heap_size-1];
        heap_size--;
        MinHeapify(0);
        return smallest;
    }
    void swap(int x, int y) {
        int temp = arr[y];
        arr[y] = arr[x];
        arr[x] = temp;
    }
    void print() {
        for(int i = 0; i < heap_size; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }



    /**
     * @param args
     */
    public static void main(String args[]) {
        Problem2 obj = new Problem2(10);
        obj.insertKey(5);
        obj.insertKey(10);
        obj.insertKey(20);
        obj.insertKey(30);
        obj.insertKey(35);
        obj.insertKey(3);
        obj.print();
        System.out.println(obj.extractMin());
        obj.print();
        System.out.println(obj.extractMin());
        obj.print();
        System.out.println(obj.getMin());
    }
}
