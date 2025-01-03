public class Problem1 {

    public static int find_missing(int[] nums) {
        if ((nums.length == 0) || (nums == null)) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == mid + 1) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,5};
        System.err.println(find_missing(nums));
    }
}
