
// Time Complexity :
//    getMin(): O(1)
//    extractMin(): O(log n)
//    insert(): O(log n)
//      n: number of elements
// Space Complexity : O(n)
//      n: number of elements
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

class MyHeap{

    // member variables
    int[] data;
    int index = -1;

    // default constructor
    MyHeap(){
        data = new int [10];
    }

    // parameterize constructor
    MyHeap(int capacity){
        data = new int [capacity];
    }

    // insert key into the heap
    public void insert(int key){

        if(data!=null && index<data.length){
            data[++index] = key;
            System.out.println(index);
            // heapify up
            if(index!=0){
                int tempIndex = index;
                int parent = (tempIndex-1)/2;
                while(tempIndex!=0 && data[parent] > data[tempIndex]){
                    int temp =  data[parent];
                    data[parent] = data[tempIndex];
                    data[tempIndex] = temp;
                    tempIndex = parent;
                    parent = (tempIndex-1)/2;
                }
            }
        }

    }

    // get minimum element
    public int getMin(){

        if(data==null || index==0){
            System.out.println("Heap empty");
            return -1;
        }else{
            return data[0];
        }

    }
    
    // pop minimum element
    public int extractMin(){
        if(data==null || index==-1){
            System.out.println("Heap empty");
            return -1;
        }else{
            int extractElement = data[0];

            // heapify down
            data[0] = data[index];
            index = index-1;
            int start = 0;
            while(start< index){
                int left = 2*start +1;
                int right = 2*start + 2;
                if(data[left] < data[right] && data[left]< data[start]){
                    int temp = data[left];
                    data[left]= data[start];
                    data[start] = temp;
                    start = left;
                }
                else if(data[right] < data[left] && data[right]< data[start]){
                    int temp = data[right];
                    data[right]= data[start];
                    data[start] = temp;
                    start = right;
                } else{
                    break;
                }
            }
            return extractElement;

        }
    }

    @Override
    public String toString() {
        StringBuilder s= new StringBuilder("MyHeap: ");
        
        for(int i=0; i<=index;i++)
            s.append(data[i]+", ");

        return s.toString();
    }

}
public class Problem2 {

    public static void main(String[] args) {
        int capacity =10;
        MyHeap myHeap = new MyHeap(capacity);
        
        for(int i=10; i> 1; i--)
            myHeap.insert(i);
        System.out.println(myHeap);

        System.out.println("--------------------------------");
        System.out.println("Min: " + myHeap.getMin());
        System.out.println("Extract Min: " + myHeap.extractMin());
        System.out.println("After extracting Min, new min: " + myHeap.getMin());

        System.out.println("--------------------------------");
        System.out.println(myHeap);
        
    }
}
