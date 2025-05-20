//Did this code successfully run :  Yes
//Any problem you faced while coding this :  No
//Time complexity - O(logN)
//Space complexity - O(1)
public class FindMissingInSortedArray {
    public static int missingNumber(int[] arr) {
        int n = arr.length;
        // Edge cases
        if (arr[0] != 1) { //First element missing
            return 1;
        }
        if (arr[n - 1] != (n + 1)) { //last element missing
            return n + 1;
        }
        // implementing binary search
        int low = 0, high = n - 1;
        while ((high - low) > 1) {
            int mid = (low + high) / 2;
            if ((arr[low] - low) != (arr[mid] - mid)) { //check left side and adjust high accordingly
                high = mid;
            } else if ((arr[high] - high) != (arr[mid] - mid)) { //check right side and adjust low accordingly
                low = mid;
            }
        }
        return (arr[low] + 1);
    }
}