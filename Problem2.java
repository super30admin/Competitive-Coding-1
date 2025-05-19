//Time complexity - add-O(log n)
// poll()	O(log n)
// peek()	O(1)
// Space complexity - O(1)
// Did you face any issues - No
public class MinHeap {
    int[] minHeap;
    int size;
    int capacity;
    
    MinHeap(int capacity) {
        this.capacity = capacity;
        this.size =0;
        this.minHeap = new int[capacity];
    }
    
    public int getParent(int i) {
        return (i-1)/2;
    }
    
     public int getLeftChild(int i) {
         return (2*i+1);
     }
     
     public int getRightChild(int i) {
         return (2*i+2);
     }
     
     public void swap(int i, int j) {
         int temp = minHeap[i];
         minHeap[i] = minHeap[j];
         minHeap[j] = temp;
     }
     
     public void add(int x) {
         if(size == capacity) {
             System.out.println("heap is full");
         } else {
             minHeap[size] = x;
             size++;
             heapifyUp(size-1);
         }
     }
     
     public void heapifyUp(int i) {
         while(i>0 && minHeap[i]< minHeap[getParent(i)]) {
             swap(i, getParent(i));
             i = getParent(i);
         }
     }
     
     public int poll() {
         if(size ==0) { System.out.println("heap is empty");
         return 0;
         }
         else {
             int t = minHeap[0];
             minHeap[0] = minHeap[size-1];
             size--;
             heapifyDown(0);
             return t;
         }
     }
    
    public void heapifyDown(int x) {
        int smallest = x;
        
        if(getLeftChild(smallest) < size && minHeap[smallest] > minHeap[getLeftChild(smallest)]) {
            smallest = getLeftChild(smallest);
        }
        if(getRightChild(smallest)<size && minHeap[smallest] > minHeap[getRightChild(smallest)]) {
            smallest = getRightChild(smallest);
        }
        
        if(x != smallest) {
            swap(x, smallest);
            heapifyDown(smallest);
        }
    }
    
    public int peek() {
        if (size == 0) {
        System.out.println("Heap is empty");
        return -1;
    }
    return minHeap[0];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);

        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(3);
        minHeap.add(2);
        minHeap.add(8);

        System.out.println("Min value: " + minHeap.peek());  // 2

         while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");  // 2 3 5 8 10
        }
    }
}

