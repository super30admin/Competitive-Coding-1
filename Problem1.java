// Time Complexity : O(log n to the base 2) where n = size of the array
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

public class FindMissingNumber {
    public static int findMissing(int[] arr) {
        int low = 0, high = arr.length - 1, mid;
        while (high >= low) {
            mid = low + (high - low) / 2;

            if ((low - mid) == (arr[low] - arr[mid])) {
                low = mid;
            } else if (arr[low] - arr[mid] == -2) {
                return arr[low] + 1;
            } else {
                high = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 4, 5, 6, 7 };

        System.out.println(findMissing(arr));
    }
}
