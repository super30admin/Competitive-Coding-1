// partially implemented minHeap, only insertKey - with O(LogN)
import java.util.Arrays;

public class MinHeap {
    int[] arr;
    int size;
    public MinHeap() {
        arr = new int[11];
        size = 0;
        Arrays.fill(arr, -1);
    }

    public void doArrange(int currKeyPlace) {
        int currIndex = currKeyPlace;
        for(int i = currKeyPlace; i>=0 && arr[i] != -1;i = (i%2 != 0 ? (i/2) : (i/2)-1)) {
            if(arr[i]>arr[currIndex]) {
                int temp = arr[i];
                arr[i] = arr[currIndex];
                arr[currIndex] = temp;
                currIndex = i;
            }
        }
    }

    public void insertKey(int key) {
        arr[size] = key;
        doArrange(size);
        size++;
    }


    public static void main(String[] args) {
        MinHeap bh = new MinHeap();
        bh.insertKey(3);
        bh.insertKey(5);
        bh.insertKey(11);
        bh.insertKey(10);
        bh.insertKey(15);
        bh.insertKey(17);
        bh.insertKey(13);
        bh.insertKey(12);
    }
}