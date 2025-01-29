
// Time Complexity: O(logn)
// Space complexity: O(1)

// Explanation: To find missing no between two nums we can take their average
// We do a binary search on the array, and discard the half where we know there is no missing no, until we get only two numbers left
// If the difference between the arr[i] and i for one of the halves is equal, it means there is no missing num between them

public class Main {
    private static int findMissingNum(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (high - low >= 2) {
            int mid = low + (high - low) / 2;
            if (arr[high] - high == arr[mid] - mid)
                high = mid;
            else
                low = mid;
        }
        return (arr[low] + arr[high]) / 2;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 4, 5, 6, 7, 8 };
        System.out.println("Missing num is: " + findMissingNum(arr));
    }
}