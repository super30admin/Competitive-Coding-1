//time complexity - O(log n) for removeing min and insert, O(1) to get min
//space complexity - O(n)
/*Approach
* used an array to implement heap structure
* insertion will happen in the last position and its positon will be adjusted with its parent till it reaches
its correct place
*getMin- top element will return
* for extractinMin which is deleting min we have to again maintain structure of minHeap(i.e lowest at the top)
so minHeapify function will get called to re-structure it
* In minheapify at any position the element is compared with its child and will be replaced from smaller one 
amongst the two(left and right)
*/
public class MinHeap{
    int[] Heap;
    int size;
    int capacity;
    
    public MinHeap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        Heap = new int[this.capacity + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    public int parent(int position){
        return (position-1)/2;
    }
    public int left(int position){
        return (position*2) +1;
    }
    public int right(int position){
        return (position*2) +2;
    }
    public void swap(int pos1, int pos2){
        int temp = Heap[pos1];
        Heap[pos1]= Heap[pos2];
        Heap[pos2] = temp; 
    }
    public boolean isLeafNode(int position){
        if(position >= (size/2) && position <= size) return true;
        return false;
    }
    public int getMin(){
        return Heap[0];
    }
    public void insert(int x){
        if(size >= capacity){
            return;
        }
        size++;
        Heap[size] = x;
        int curr = size;
        while(Heap[curr] < Heap[parent(curr)]){
            swap(curr, parent(curr));
            curr =parent(curr);
        }
    }
    public int extractMin(){//delete min from heap
        int removed = Heap[0];
        Heap[0] = Heap[size--];
        minHeapify(0);
        return removed;
    }
    public void minHeapify(int position) 
    { 
        if (!isLeafNode(position)) { 
            if (Heap[position] > Heap[left(position)] 
                || Heap[position] > Heap[right(position)]) { 
 
                if (Heap[left(position)] < Heap[right(position)]) { 
                    swap(position, left(position)); 
                    minHeapify(left(position)); 
                } 
                else { 
                    swap(position, right(position)); 
                    minHeapify(right(position)); 
                } 
            } 
        } 
    } 
  
    public static void main(String[] args) 
    { 
        MinHeap minHeap = new MinHeap(15); 
        minHeap.insert(4); 
        minHeap.insert(3); 
        minHeap.insert(16); 
        minHeap.insert(12); 
        minHeap.insert(79); 
        minHeap.insert(19); 
        minHeap.insert(7); 
        minHeap.insert(45); 
        minHeap.insert(15); 
  
        System.out.println("The Min val is " + minHeap.getMin()); 
        minHeap.extractMin();
        System.out.println("Min is removed------");
        System.out.println("The Min val is " + minHeap.getMin()); 
        minHeap.extractMin();
        System.out.println("Min is removed-------");
        System.out.println("The Min val is " + minHeap.getMin()); 


    } 



}
