// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class FindMissingInteger {
    static int binarySearch(int arr[],
                            int size)
    {
        int low = 0, high = size - 1;
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            // If the middle element is not on
            // the middle index, then the missing element is mid + 1.
            if (arr[mid] != mid + 1 && arr[mid - 1] == mid)
            {
                return mid + 1;
            }

            // This case means that the missing element is
            // not to the low. So search the high.
            if (arr[mid] == mid + 1)
                low = mid + 1;

                // This case means that the missing element is not
                // to the high. So search the low.
            else
                high = mid - 1;
        }
        // Will reach here if no missing element found.
        return -1;
    }

    // Driver Code
    public static void main (String[] args)
    {
        int ar[] = { 1, 2, 3, 4, 6, 7, 8 };
        int size = ar.length;
        System.out.println("Missing number: " +
                binarySearch(ar, size));
    }
}