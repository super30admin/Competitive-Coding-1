
import java.util.Arrays;
//insert and remove(o(logn))


public class MinHeap{
    int capacity;
    int min;
    int[] arr;
    int curr;
    public MinHeap(int capacity){
        this.capacity = capacity;
        this.curr = 0;
        this.arr = new int[capacity];
        this.min = Integer.MAX_VALUE;
    }

    public int getLeft(int pos){
        return 2 * pos + 1;
    }

    public int getRight(int pos){
        return 2 * pos + 2;
    }

    public int parent(int pos){
        if(pos == 1 || pos == 2) return 0;

        if (pos % 2 != 0)return pos / 2;
        return pos / 2 - 1 ;
    }

    public void swap(int pos1, int pos2){
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    public boolean isEmpty(){
        return curr == 0;
    }

    public void insert(int value){
        if(curr < capacity){
            arr[curr] = value;
            heapifyUp(curr);
            curr++;
        }
    }

    public int remove(){
        if(curr == 0) return -1;
        int res = arr[0];
        curr--;

        arr[0] = arr[curr];
        arr[curr] = 0;
        int i = 0;
        while(i <= curr){

            if(getLeft(i) < curr && arr[getLeft(i)] - arr[i] < arr[getRight(i)] - arr[i] && arr[getLeft(i)] - arr[i] < 0){
                swap(i, getLeft(i));
                i = getLeft(i);
            } else if( getRight(i) < curr && arr[getRight(i)] - arr[i] < arr[getLeft(i)] - arr[i] && arr[getRight(i)] - arr[i] < 0) {
                swap(i, getRight(i));
                i = getRight(i);
            } else {
                i++;

            }
        }
        return res;
    }
    public void heapifyUp(int pos){
        while(parent(pos) >= 0 && arr[parent(pos)] > arr[pos]){
            swap(parent(pos), pos);
            pos = parent(pos);
        }
    }
    public void toSString(){
        System.out.println(Arrays.toString(arr));
    }




    public static void main(String[] args) {
        MinHeap h = new MinHeap(10);
        h.insert(10);
        h.toSString();
        h.insert(5);
        h.toSString();
        h.insert(7);
        h.toSString();
        h.insert(9);
        h.toSString();
        h.insert(19);
        h.toSString();
        h.insert(2);
        h.toSString();
        h.insert(4);
        h.toSString();
        h.insert(90);
        h.toSString();
        h.insert(1);
        h.toSString();
        h.insert(78);
        h.toSString();
        System.out.println(h.curr);
        System.out.println(h.remove());
        h.toSString();
        h.remove();
        h.toSString();

    }
}