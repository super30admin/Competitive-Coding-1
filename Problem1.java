/**
 * Min Heap is the data structure which stores the min ele at the 0th index in an array
 * * Time Complexity: insert and extractMin operations O(log n) and getMin- O(1)
 *   Space Complexity: O(n) to store the input in an arr
 */
class MinHeap{
    int[] arr;
    int size;
    int capacity;
    MinHeap(){
        capacity = 16;                                          //inital capacity used by java impl.
        arr = new int[capacity];
        size = 0;                                               //keeps track of the size of the array filled
    }

    /**
     * assign new input ele at the end of the array and move it up by checking with its parent ele
     * @param x
     */
    public void insert(int x){
        if(size == capacity)                                   //if the aray is filled then double the array size
            doubleArray();
        arr[size++] = x;                                      //assign new input ele at the end of the array
        peroclateUp(size-1, x);                          //and move it up by checking with its parent ele
    }

    /**
     * Double the size of the existing array and capacity
     */
    public void doubleArray(){
        capacity <<= 1;
        int[] newarr = new int[capacity];
        for(int i=0;i<size;i++)
            newarr[i] = arr[i];
        arr = newarr;
    }

    /**
     * check for the position of the newly added ele and assign it there
     * @param size
     * @param x
     */
    public void peroclateUp(int size,int x){
        int hole = size;
        while((hole-1)/2 >= 0 && hole > 0){
            if(x < arr[(hole-1)/2]) {
                arr[hole] = arr[(hole-1)/2];
                hole = (hole-1)/2;
            }
            else
                break;
        }
        arr[hole] = x;
    }

    /**
     * return the min of the array
     * @return
     */
    public int getMin(){
        return arr[0];
    }

    /**
     * remove the min ele and move the elements accordingly (to satisy min heap property)
     * @return
     */
    public int extractMin(){
        int minele = arr[0];
        arr[0] = arr[--size];
        if(size > 1)
            percolateDown(arr[0]);
        return minele;
    }

    /**
     * after removing the min ele, reorder the elements need be to preserve min heap property
     * @param x
     */
    public void percolateDown(int x){
        int hole = 1;
        while(hole <= size){
            if(hole+1 <= size && arr[hole+1] < arr[hole])
                hole++;
            if(arr[hole] < x)
                arr[(hole-1)/2] = arr[hole];
            else
                break;
            hole <<= 1;
        }
        arr[hole] = x;
    }

    /**
     * prints the ele in the array
     */
    public void print(){
        for(int i=0;i<size;i++)
            System.out.println(arr[i]);
    }
    public static void main(String[] args){
        MinHeap input = new MinHeap();
        input.insert(1);
        input.insert(-1);
        input.insert(0);
        input.print();
        System.out.println(input.getMin());
        System.out.println(input.extractMin());
        input.print();
        System.out.println(input.extractMin());
        input.print();
        System.out.println(input.extractMin());
    }

}