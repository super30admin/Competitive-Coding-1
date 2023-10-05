// Find Missing Number in a sorted array
// Time - o(logn)
// Space - o(1)
public class Problem1 {
    public static int findMissingNumber(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            int highDiff = arr[high] - high;
            int lowDiff = arr[low] - low;
            int midDiff = arr[mid] - mid;

            if (midDiff != highDiff - lowDiff) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return arr[low] - 1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,7,8,9,10};
        int missingNumber = findMissingNumber(arr);
        System.out.println("Missing number: " + missingNumber);
    }
}