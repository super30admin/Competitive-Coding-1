// Time complexity: O(logn)
// Space complexity: O(1)
/* Approach: If mid value = mid + 1; then left side is fine, move to right side.
 * If mid value != mid + 1; then element lies on the left. When the loop exits,
 * the low pointer points to the first element that is out of order (if there's one).
 * So, return either low + 1 or nums[low] - 1
*/

class Problem1 {
    public static void main(String[] args) {
        System.out.println(findMissingElement(new int[] { 1, 2, 4, 5, 6, 7 }));
    }

    public static int findMissingElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        // play with low <= high; low + 1 or high - 1 can be returned
        while (low < high) {
            int mid = low + (high - low) / 2; // prevent integer overflow
            // integer number line; you can imagine it as a circle; if you exceed the
            // INT_MAX, it comes back to -2^31 and can give you a wrong value
            int midValue = nums[mid];

            if (mid + 1 == midValue) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        // if
        if (nums[low] == low + 1) {
            return -1;
        } else {
            return nums[low] - 1;
        }
    }
}