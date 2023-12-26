public class Main {
    public static void main(String[] args) {
        int[] arr = {1,3};
        int result = findMissingNumberInSortedArray(arr);
        System.out.println(result);
    }
    // TC: O(log N) where N is the size of arr
    // SC: O(1)
    private static int findMissingNumberInSortedArray(int[] arr) {
        int low = 0, high = arr.length - 1, n = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid >= 1 && arr[mid] != arr[mid - 1] + 1) {
                return arr[mid - 1] + 1;
            } else if (mid + 1 < n && arr[mid] != arr[mid + 1] - 1) {
                return arr[mid + 1] - 1;
            } else if (arr[mid] > mid + 1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
