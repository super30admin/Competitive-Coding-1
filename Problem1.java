// Question - Find Missing Number in a sorted array
// Time complexity - O(log(n))
// Space complexity - O(1)

public class Problem1 {
    public static int findMissing(int[] a) {
        if (a == null || a.length == 0) {
            return -1;
        }

        int low = 0, high = a.length - 1;

        int mid = -1;

        if (high == a[high] - 1) {
            return -1;
        }

        while (low <= high) {
            mid = low + (high - low) / 2; // prevent overflow

            if (a[mid] == mid + 1) { // left is sorted
                low = mid + 1;
            } else { // right is sorted
                high = mid - 1;
            }
        }

        return mid + 1;
    }

    public static void main(String[] args) {
        int[] tc = { 1, 2, 3, 4, 5, 6 };
        // int[] tc = {1};
        int missing = findMissing(tc);
        System.out.println(missing);
    }
}