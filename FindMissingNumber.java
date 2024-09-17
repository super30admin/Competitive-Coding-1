// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes (On GeeksForGeeks)
// Any problem you faced while coding this : No

class FindMissingNumber {
    static int search(int arr[], int size) {
        if (arr[0] != 1)
            return 1;
        if (arr[size - 1] != (size + 1))
            return size + 1;

        int low = 0, high = size - 1;
        int mid = 0;
        while ((high - low) >= 2) {
            mid = low + (high - low) / 2;
            int midIdxDiff = arr[mid] - mid;
            int lowIdxDiff = arr[low] - low;
            if (midIdxDiff != lowIdxDiff) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return (arr[high] + arr[low]) / 2;
    }

    // Driver Code
    public static void main(String[] args) {
        int ar[] = { 1, 2, 3, 4, 6, 7, 8 };
        int size = ar.length;
        System.out.println("Missing number: "
                + search(ar, size));
    }
}