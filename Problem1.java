// Find Missing Number in a sorted array
// https://youtu.be/LwmckBrlrRs
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

            // Check if the missing number is on the left side
            if (midDiff != highDiff - lowDiff) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        // At this point, low and high will be equal, and you can return either of them
        return arr[low] - 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 7, 8};
        int missingNumber = findMissingNumber(arr);
        System.out.println("Missing number: " + missingNumber);
    }
}