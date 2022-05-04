// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class Problem2{

    private int[] Heap;
    private int size;
    private int max_size;
    private static final int front = 1;

    public Problem2(int max_size){
        this.max_size = max_size;
        this.Heap = new int[this.max_size+1];
        this.size = 0;
        Heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos){//node position of the current parent 
        return pos/2;
    }
    
    private int left_child(int pos){//node position of current left child
        return pos*2;
    }

    private int right_child(int pos){//node position of current left child
        return (pos*2)+1;
    }

    private boolean isLeaf(int pos){//check if passed node is the left node
        if(pos>(size/2) && (pos<=size)){
            return true;
        }else{
            return false;
        }
    }

    private void swap(int first_pos, int second_pos){//swap between first and second pos
        int temp = Heap[first_pos];
        Heap[first_pos] = Heap[second_pos];
        Heap[second_pos] = temp;
    }

    private void insert(int value){//insert into your heap
        if(size>=max_size){
            return;
        }else{
            Heap[++size] = value;
            int current = size;

            while(Heap[current] < Heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
        }
    }

    private int remove(){//remove from your heap
        int pop = Heap[front];
        Heap[front] = Heap[size--];
        heapify(front);
        return pop;
    }

    private void heapify(int pos){
        if(!isLeaf(pos)){
            //check is value is greater than both children
            if((Heap[pos]>Heap[left_child(pos)]) || (Heap[pos]>Heap[right_child(pos)])){
                //then check with left - if left smaller swap and heapify to adjust
                if(Heap[left_child(pos)]<Heap[right_child(pos)]){
                    swap(pos, left_child(pos));
                    heapify(pos);
                }else{
                //if not left check with right - if right smaller swap and heapify to adjust    
                    swap(pos, right_child(pos));
                    heapify(pos);
                }
            }
        }
    }

    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {
 
            // Printing the parent and both childrens
            System.out.print(
                " PARENT : " + Heap[i]
                + " LEFT CHILD : " + Heap[2 * i]
                + " RIGHT CHILD :" + Heap[2 * i + 1]);
 
            // By here new line is required
            System.out.println();
        }
    }
 
    public static void main(String[] arg)
    {
 
        // Display message
        System.out.println("The Min Heap is ");
 
        // Creating object opf class in main() methodn
        Problem2 minHeap = new Problem2(15);
 
        // Inserting element to minHeap
        // using insert() method
 
        // Custom input entries
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
 
        // Print all elements of the heap
        minHeap.print();
 
        // Removing minimum value from above heap
        // and printing it
        System.out.println("The Min val is "
                           + minHeap.remove());
    }
}