// Time Complexity : O(log N)
// Space Complexity : O(1)


// Your code here along with comments explaining your approach:
// we can divide the array by mid, if the value at mid is equal to mid+1 index that means there is no value
// missing before mid+1 and there might be value missing after mid, so I search for missing value after mid.
// If mid+1 is less than the current value, that means value must be missing before mid, so I search in values
// before mid. At the end low+1 index will point to my missing value.

public class SearchMissingValue {
    public static void main(String[] args) {
        int ar[] = {2, 3, 4, 5, 6, 7, 8, 9};
        int size = 8;
        System.out.println("Missing number: " +
                search(ar, size));

    }

    private static int search(int[] arr, int size) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid + 1 < arr[mid]) {
                high = mid - 1;
            } else if (mid + 1 == arr[mid]) {
                low = mid + 1;
            }
        }

        return low + 1;
    }

}
