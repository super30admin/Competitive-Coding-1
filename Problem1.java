//Time Complexity -- O(logn)
//Space Complexity -- O(1)
class Problem1{
      public static int missingNumber(int[] arr) {
        int n = arr.length;

        if (arr[0] != 1) {
            return 1;
        }
        if (arr[n - 1] != (n + 1)) {
            return n + 1;
        }

        int low = 0; 
        int high = n - 1;
        while ((high - low) > 1) {
            int mid = low + (high - low) / 2;
            if ((arr[low] - low) != (arr[mid] - mid)) {
                high = mid;
            } else if ((arr[high] - high) != (arr[mid] - mid)) {
                low = mid;
            }
        }
        return (arr[low] + 1);
    }
}
