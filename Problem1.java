public class Problem1 {
    public static int findMissingElement(int[] arr) {
        int length = arr.length;

        int low = 0; int high = length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] != mid + 1) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low + 1;
    }

    public static void main() {
        System.out.println(findMissingElement());
    }
}
