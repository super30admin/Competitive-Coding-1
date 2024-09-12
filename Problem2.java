package CP1;

import java.util.ArrayList;
import java.util.Collections;

/*
 * For insertion we insert at the last and bubble up the element if (parent>element)
 * For removal we swap first and last element and bubble down the first element if (child<element)
 * 
 * 
 * Insertion - O(Logn) as we do the bubble up operation worst case till the height of tree.
 * Removal - O(Logn) bubble down till height of tree in worst case
 * getMin() - O(1)
 * getLength() - O(1)
 *  
 * Space - O(1) if we are given array as input
 *       - O(n) otherwise
 *      
 */

public class Problem2 {
	ArrayList<Integer> arr;

	Problem2() {
		arr = new ArrayList<>();
	}

	int findMin() {
		return arr.get(0);
	}

	int getLength() {
		return arr.size();
	}

	private void swap(ArrayList<Integer> arr, int idx1, int idx2) {
		Collections.swap(arr, idx1, idx2);
	}

	void insert(int x) {
		if (arr.size() == 0) {
			arr.add(x);
			return;
		}

		arr.add(x);
		int idx = arr.size() - 1;
		int parentIdx = (idx - 1) / 2;

		do {
			if (arr.get(idx) < arr.get(parentIdx)) {
				swap(arr, idx, parentIdx);
				idx = parentIdx;
				parentIdx = (idx - 1) / 2;

			}
		}

		while (parentIdx >= 0 && arr.get(idx) < arr.get(parentIdx));

	}

	void remove() {
		if (arr.size() == 0)
			return;
		else if (arr.size() == 1)
			arr.remove(arr.size() - 1);

		swap(arr, 0, arr.size() - 1);
		arr.remove(arr.size() - 1);

		int idx = 0;
		int idxLchild = 1;
		int idxRchild = 2;
		boolean leftFlag=false;

		do {
			if (idxLchild < arr.size() && arr.get(idx) > arr.get(idxLchild)) {
				swap(arr, idx, idxLchild);
				leftFlag=true;
			}
			if (idxRchild < arr.size() && arr.get(idx) > arr.get(idxRchild)) {
				swap(arr, idx, idxRchild);
				leftFlag=false;
			}
			
			if(leftFlag==true)
				idx=idxLchild;
			else
				idx=idxRchild;

			idxLchild = idx * 2 + 1;
			idxRchild = idx * 2 + 2;

		} while (idxLchild < arr.size() && idxRchild < arr.size());

	}

	public static void main(String[] args) {
		Problem2 heap = new Problem2();
		heap.insert(15);
		System.out.println(heap.arr);
		heap.insert(28);
		System.out.println(heap.arr);
		heap.insert(16);
		System.out.println(heap.arr);
		heap.insert(32);
		System.out.println(heap.arr);
		heap.insert(31);
		System.out.println(heap.arr);
		heap.insert(20);
		System.out.println(heap.arr);
		heap.insert(5);
		System.out.println(heap.arr);

		heap.remove();
		System.out.println(heap.arr);
		heap.remove();
		System.out.println(heap.arr);
		heap.remove();
		System.out.println(heap.arr);
		heap.remove();
		System.out.println(heap.arr);
		heap.remove();
		System.out.println(heap.arr);
		heap.remove();
		System.out.println(heap.arr);

	}
}
