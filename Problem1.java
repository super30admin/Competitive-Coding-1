//Time complexity: O(log n)
//Space Complexity: O(1)

class Solution {
    static int helper(int ar[], int size) {
        int low = 0;
        int high = size;

        while (high - low >= 2) {
            int mid = low + (high - low) / 2;
            int midIdx = ar[mid] - mid;
            int lowIdx = ar[low] - low;
            int highIdx = ar[high] - high;
            if (midIdx != lowIdx) {
                high = mid;
            } else if (midIdx != highIdx) {
                low = mid;

            }

        }
        return (ar[high] + ar[low]) / 2;

    }

    public static void main(String[] args) {
        int ar[] = { 1, 2, 3, 4, 5, 7 };
        int size = ar.length;
        System.out.println("Missing number: " + helper(ar, size-1));

    }
} 