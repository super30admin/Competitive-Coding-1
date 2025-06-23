public class MissingNumber {
    public static int missingNumber(int[] arr) {
        int n = arr.length;

        if (arr[0] != 1) {
            return 1;
        }
        if (arr[n - 1] != (n + 1)) {
            return n + 1;
        }

        int lo = 0, hi = n - 1;
        while ((hi - lo) > 1) {
            int mid = (lo + hi) / 2;
            if ((arr[lo] - lo) != (arr[mid] - mid)) {
                hi = mid;
            } else if ((arr[hi] - hi) != (arr[mid] - mid)) {
                lo = mid;
            }
        }
        return (arr[lo] + 1);
    }
}
