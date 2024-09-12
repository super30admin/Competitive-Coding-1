
/*
 * Time complexity - O(logn)
 * Space Complexity - O(1)
 * 
 * Implemented using binary search
 */

public class MissingElement {

	static int search(int ar[], int size) {
		int l = 0, r = size - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (ar[mid] != mid + 1 && ar[mid - 1] == mid) {
				System.out.println(ar[mid]);
				return (mid + 1);
			}

			if (ar[mid] != mid + 1)
				r = mid - 1;
			else
				l = mid + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int ar[] = { 1, 2, 4, 5, 6, 7, 8 };
		int size = ar.length;
		System.out.println("Missing number: " + search(ar, size));
	}

}
