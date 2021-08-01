public class Problem1 {

    //Space complexity O(1)
    //Time complexity O(logn)
    public int search(int[] ar, int size) {
        int low = 0;
        int high = size - 1;
        int mid = 0;

        while (high - low >= 2) {
            mid = low + (high - low) / 2;
            int midIndexDiff = ar[mid] - mid;
            int lowIndexDiff = ar[low] - low;
            int highIndexDiff = ar[high] - high;
            if (midIndexDiff != lowIndexDiff) {
                high = mid;
            } else if (midIndexDiff != highIndexDiff) {
                low = mid;
            }
        }

        return (ar[low] + ar[high]) / 2;
    }

}