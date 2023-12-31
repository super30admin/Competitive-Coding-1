class MinHeap {
   
    // by default it is a min heap. elements are sorted in natural order.
    PriorityQueue<Integer> queue = new PriorityQueue<>();
   
    //o(logn)
    public void insert(int a){
        queue.add(a);
    }
    //o(1)
    public int getMin(){
        if(queue.isEmpty()){
            return -1;
        }
        return queue.peek();
    }
    //o(logn)
    public int extractMin(){
        if(queue.isEmpty()){
            return -1;
        }
        return queue.poll();
    }
   
}
public class Main {
    public static void main(String[] args) {
        MinHeap m = new MinHeap();
        m.insert(10);
        m.insert(5);
        m.insert(24);
        m.insert(2);
        System.out.println(m.getMin());
        m.extractMin();
        System.out.println(m.getMin());
       
    }
}
