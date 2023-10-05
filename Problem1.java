public class MissingElement {

    /**
     * TC: O(log n) <br>
     * SC: O(1)
     */
    public int findMissing(int[] nums, int n) {
        // Binary Search
        int lo = 1;
        int hi = n;
        int mid;

        int answer = -1;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;

            // base case
            if (nums[mid - 1] != mid) {
                // missing found
                // answer = mid;
                // break;
                return mid;
            }
            if (nums[mid - 1] - nums[lo - 1] != mid - lo) {
                // move to left
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 8 };
        int n = 8;

        MissingElement obj = new MissingElement();
        int missingElement = obj.findMissing(nums, n);

        System.out.println(missingElement);
    }

}
