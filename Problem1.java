// Time Complexity : O( logn), n is the length of the array.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
/*
 * we can check the differenc between the current element and its index .
 * Check the same for mid and low, if the difference is not equal then the missing eleement is on the left side or the right side
 */
class Problem1 {

    static int findMissingNumber(int[] arr) {

        int low = 0, high = arr.length - 1;

        while (high - low >= 2) {
            int mid = low + (high - low) / 2;
            int midDiff = arr[mid] - mid;
            int lowDiff = arr[low] - low;
            int highDiff = arr[high] - high;
            if (midDiff != lowDiff) {
                high = mid;
            } else if (midDiff != highDiff) {
                low = mid;
            }

        }

        return (arr[low] + arr[high]) / 2;
    }

    public static void main(String[] args) {

        int[] arr = new int[] { 1, 2, 3, 5, 6, 7, 8 };

        System.out.println("Missing number:" + findMissingNumber(arr));

    }
}
