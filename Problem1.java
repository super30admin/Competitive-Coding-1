// Time complexity: O(log n)
// Space Complexity: O(1)
// Approach:we can implement it using Binary search with TC o(log n). check the element at a[0]. find the mid. if a[mid]-a[0] == mid then the missing element is at the right side or it will be at the left side.

class GFG {
    public int missing(int[] a, int n) {
        int low = 0;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid < n && a[mid] - a[0] != mid) {
                for (int i = low; i <= mid; i++) {
                    if (i < n - 1 && a[i + 1] - a[i] != 1) return a[i] + 1;
                }
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 7, 8};
        int n = a.length - 1;
        GFG calc = new GFG();
        System.out.println(calc.missing(a, n));
    }
}