import java.util.Stack;

public class MinHeap{

        Stack<Integer> in;
        Stack<Integer> out;

        MinHeap(){
            this.in = new Stack<>();
            this.out = new Stack<>();
        }

        private void push(int data){
            if(in.isEmpty() || data<in.peek()){
                in.push(data);
            }
            else {
                while(!in.isEmpty() && data>in.peek()){
                    out.push(in.pop());
                }
                in.push(data);
                while(!out.isEmpty()){
                    in.push(out.pop());
                }
            }
        }

        private int pop(){
            return in.pop();
        }

        public static void main (String[] args){
            MinHeap minHeap = new MinHeap();
            minHeap.push(3);
            minHeap.push(7);
            minHeap.push(9);
            minHeap.push(4);
            minHeap.push(10);
            System.out.println("The minimum element is: " + minHeap.pop());
            System.out.println("The minimum element is: " + minHeap.pop());
        }
}
