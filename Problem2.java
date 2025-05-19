/*
 * 
 * Below is the solution to Design min Heap using Java Array list.
 * Time and Space Complexity
 * Operation        Time Complexity             Space Complexity
 * push()               O(log n)                     O(1)
 * pop()                O(log n)                     O(1)
 * HeapifyUp()          O(log n)                     O(log n) (recursive)
 * HeapifyDown()        O(log n)                     O(log n) (recursive)
 * buildHeap()          O(n)                         O(1)
 * getMin()             O(1)                         O(1)
 * show()               O(n)                         O(1)
 */

import java.util.ArrayList;
import java.util.Arrays;

class MinHeap {
    ArrayList<Integer> Heap = new ArrayList<>();
    int size_;

    MinHeap() {
        size_ = -1;
    }

    void HeapifyUp(int idx) {
        if (idx == 0) {
            return;
        }
        int p_index = (idx - 1) / 2;
        if (Heap.get(idx) < Heap.get(p_index)) {
            int temp = Heap.get(p_index);
            Heap.set(p_index, Heap.get(idx));
            Heap.set(idx, temp);
            HeapifyUp(p_index);
        }
    }

    void HeapifyDown(int idx) {
        int smallest = idx;
        int left = (2 * idx) + 1;
        int right = (2 * idx) + 2;
        if ((left < size_) && (Heap.get(left) < Heap.get(smallest))) {
            smallest = left;
        }
        if ((right < size_) && (Heap.get(right) < Heap.get(smallest))) {
            smallest = right;
        }
        if (smallest != idx) {
            int temp = Heap.get(idx);
            Heap.set(idx, Heap.get(smallest));
            Heap.set(smallest, temp);
            HeapifyDown(smallest);
        }
    }

    void push(int x) {
        Heap.add(x);
        size_ += 1;
        if (size_ == 0) {
            return;
        }
        HeapifyUp(size_);
    }

    int pop() {
        int temp = Heap.get(0);
        Heap.set(0, Heap.get(size_));
        Heap.remove(size_);
        HeapifyDown(0);
        size_ -= 1;
        return temp;
    }

    void show() {
        int n = Heap.size();
        for (int i = 0; i < n; i++) {
            System.out.println(Heap.get(i));
        }
    }

    boolean isEmpty() {
        return size_ == -1;
    }

    int size() {
        return size_;
    }

    int getMin() {
        return Heap.get(0);
    }

    int[] buildHeap(int[] nums) {
        int n = nums.length / 2;
        for (int i = n; i >= 0; i--) {
            down(i, nums);
        }
        return nums;
    }

    void down(int idx, int[] nums) {
        int n = nums.length;
        int s = idx;
        int l = (2 * idx) + 1;
        int r = (2 * idx) + 2;
        if ((l < n) && (nums[l] < nums[s])) {
            s = l;
        }
        if ((r < n) && (nums[r] < nums[s])) {
            s = r;
        }
        if (s != idx) {
            int temp = nums[s];
            nums[s] = nums[idx];
            nums[idx] = temp;
            down(s, nums);
        }
    }
}

public class Problem2 {
    public static void main(String[] args) {
        MinHeap mH = new MinHeap();
        mH.push(-5);
        mH.push(-3);
        mH.push(-8);
        mH.push(-2);
        mH.show();
        System.out.println(mH.pop());
        mH.show();
        System.out.println(mH.pop());
        mH.show();
        int[] nums = { 8, 6, 5, 3, 2, 1 };
        System.out.println(Arrays.toString(mH.buildHeap(nums)));
    }
}