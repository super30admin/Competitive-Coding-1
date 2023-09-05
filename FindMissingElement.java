// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Not applicable
// Any problem you faced while coding this :
public class FindMissingElement {
    public static void main(String[] args) {
        int[] arr = {2, 3};
        int result = findMissingElement(arr);
        System.out.println("Missing Element is " + result);
    }

    private static int findMissingElement(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        if (arr[0] != 1)
            return 1;
        if (arr[high - 1] != (high + 1))
            return high + 1;
        while ((high - low) > 1) {
            int mid = low + (high - low)/2;
            if ((arr[low] - low) != (arr[mid] - mid))
                high = mid;
            else if ((arr[high] - high) != (arr[mid] - mid))
                low = mid;
        }
        return (arr[low] + 1);
    }
}