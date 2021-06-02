public class Problem1 {

    //Space complexity O(1)
    //Time complexity O(logn)
    public int search(int[] arrary, int size) {
        int low = 0;
        int high = size - 1;
        int mid = 0;

        while ((high - low) > 1) {
            mid = (low + high) / 2;
            if ((arrary[low] - low) != array[mid] - mid) {
                high = mid;
            } else if ((arrary[high] - high) != (arrary[mid] - mid)) {
                low = mid;
            }
        }
        return arrary[low] + 1;
    }

}