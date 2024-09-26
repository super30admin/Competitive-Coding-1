// Time Complexity : for insertion and deletion operations - O(log n to the base 2) where n = size of the array 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

public class MinHeap {
    int[] minHeap;
    int heapSize;
    int realSize = 0;

    public MinHeap(int heapSize) {
        this.heapSize = heapSize;
        minHeap = new int[heapSize];
    }

    public void swap(int left, int right) {
        int temp = minHeap[left];
        minHeap[left] = minHeap[right];
        minHeap[right] = temp;
    }

    public int calcMin(int left, int right) {
        return minHeap[left] < minHeap[right] ? left : right;
    }

    public void insert(int val) {
        if (realSize == heapSize) {
            System.out.println("Max HeapSize reached");
            return;
        }
        minHeap[realSize] = val;
        int temp = realSize;
        while (temp > 0) {
            if (minHeap[(temp - 1) / 2] > minHeap[temp]) {
                swap((temp - 1) / 2, temp);
                temp /= 2;
            } else {
                break;
            }
        }
        realSize += 1;
    }

    public int getMin() {
        return minHeap[0];
    }

    public int extractMin() {
        int temp = minHeap[0];
        int n = 0;
        minHeap[n] = minHeap[--realSize];
        while (n <= realSize / 2) {
            if (minHeap[n] > Math.min(minHeap[2 * n + 1], minHeap[2 * n + 2])) {
                int min = calcMin(2 * n + 1, 2 * n + 2);
                swap(n, min);
                n = min;
            } else {
                break;
            }
        }
        return temp;
    }

    public int size() {
        return realSize;
    }

    public String toString() {
        if (realSize == 0) {
            return "No element!";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (int i = 0; i < realSize; i++) {
                sb.append(minHeap[i]);
                sb.append(',');
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(']');
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        // Test case
        MinHeap minHeap = new MinHeap(3);
        minHeap.insert(3);
        minHeap.insert(1);
        minHeap.insert(2);
        // [1,3,2]
        System.out.println(minHeap.toString());
        // 1
        System.out.println(minHeap.getMin());
        // 1
        System.out.println(minHeap.extractMin());
        // [2, 3]
        System.out.println(minHeap.toString());
        minHeap.insert(4);
        // Max HeapSize Reached
        minHeap.insert(5);
        // [2,3,4]
        System.out.println(minHeap.toString());
    }
}
