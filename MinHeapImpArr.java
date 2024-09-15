public class MinHeapImpArr {

    private int[] minHeap;
    private int size;
    private int capacity;

    public static final int FRONT = 1;
    //constructor
    public MinHeapImpArr(int capacity){

        this.capacity = capacity;
        this.size = 0;

        minHeap = new int[this.capacity +1];
        minHeap[0] =  Integer.MIN_VALUE;

    }

    // 1. method to return position of parent of a node at posit k
    private int parentOfaNode(int k){
        return k/2;
    }

    // 2. method to return position of left child of a node at posit k
    private int leftChildOfaNode(int k){
        return k*2;
    }

    // 3. method to return position of right child of a node at posit k
    private int rightChildOfaNode(int k){
        return k*2 + 1;
    }

    // 4. method to check if a node is a leaf node
    private boolean ifLeaf(int k){
        if(k > size/2)
            return true;
        else
            return false;
    }

    //5. method to swap nodes
    private void swapHeap(int firstPosit, int secondPosit){

        int temp = minHeap[firstPosit];
        minHeap[firstPosit] = minHeap[secondPosit];
        minHeap[secondPosit] = temp;
    }

    // 6. method to heapify
    private void minHeapify(int m){

        if(!ifLeaf(m)){
            int p = m;
            if(rightChildOfaNode(m) <= size) {
                p = minHeap[leftChildOfaNode(m)] < minHeap[rightChildOfaNode(m)] ?
                        leftChildOfaNode(m) : rightChildOfaNode(m);
            }
            else
                p = leftChildOfaNode(m);

            //maintaining heap property
            if((minHeap[m] > minHeap[leftChildOfaNode(m)]) ||
                    (minHeap[m] > minHeap[rightChildOfaNode(m)]))
            {
                swapHeap(m, p);
                minHeapify(p);
            }

        }

    }

    // 7. method to add
    private void insert(int k){

        if(size >= capacity)
            return;

        minHeap[++ size] = k;
        int curr = size;

        while(minHeap[curr] < minHeap[parentOfaNode(curr)]){
            swapHeap(curr, parentOfaNode(curr));
            curr = parentOfaNode(curr);
        }

    }

    // 8. method to print nodes of a min heap
    public void printHeap(){
        for(int i = 0; i <= size/2; i++){
            System.out.println("parent: "+ minHeap[i] + "  left child: " + minHeap[2*i]
              + "  right child is " + minHeap[2*i + 1]);

            System.out.println();
        }
    }

    // 9. method to return minimum element in heap
    private int getMin(){

        int minimum = minHeap[FRONT];
        minHeap[FRONT] = minHeap[size --];

        minHeapify(FRONT);
        return minimum;
    }

    // 10. main method
    public static void main(String[] args){
        System.out.println(" Min Heap: ");

        MinHeapImpArr object = new MinHeapImpArr(10);

        // custom inputs
        object.insert(13);
        object.insert(16);
        object.insert(31);
        object.insert(41);
        object.insert(51);
        object.insert(100);
        object.insert(41);

        //printing
        object.printHeap();

        //printing min val
        System.out.println("Min Value is " + object.getMin());

    }


}
