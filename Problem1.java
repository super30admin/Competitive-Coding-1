//Time complexity:O(logn)
//Space complexity:O(1)
class Solution {
    public int Example(int[] a) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check left neighbor
            if (mid > 0 && a[mid] - a[mid - 1] > 1) {
                return a[mid] - 1;
            }

            // Check right neighbor
            if (mid < a.length - 1 && a[mid + 1] - a[mid] > 1) {
                return a[mid] + 1;
            }

            // Standard binary search adjustment
            if (a[mid]-1 == mid) {
                // Left side is perfect, move right
                low = mid + 1;
            } else {
                // Mismatch → missing is on the left 
                high = mid - 1;
            }
        }

        // Edge case: missing number is at the end
        return a.length;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = { 1, 2, 3, 5, 6};   // missing 4
        int[] arr2 = { 1, 3, 4, 5};      // missing 2
        

        System.out.println("Missing number in arr1: " + sol.Example(arr1)); // 4
        System.out.println("Missing number in arr2: " + sol.Example(arr2)); // 2
        
}

}

