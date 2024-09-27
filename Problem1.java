//Time complexity: O(log n)
//Space Complexity: O(1)

class Solution {

    static int search(int ar[], int size) {
        int low = 0;
        int high = size - 1;

        while (high - low >= 2) {
            int mid = low + (high - low) / 2;
            int midindexdiff = ar[mid] - mid;
            int lowindexdiff = ar[low] - low;
            int highindexdiff = ar[high] - high;
            if (midindexdiff != lowindexdiff) {
                high = mid;
            } else if (midindexdiff != highindexdiff) {
                low = mid;

            }

        }
        return (ar[high] + ar[low]) / 2;

    }

    public static void main(String[] args) {
        int ar[] = { 1, 2, 3, 4, 5, 6, 8 };
        int size = ar.length;
        System.out.println("Missing number: " + search(ar, size));

    }
} 
