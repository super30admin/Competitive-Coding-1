public class findMissing {
    public int findMissingInteger(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] != mid + 1) {
                if (mid == 0 || nums[mid - 1] == mid) {
                    return mid + 1;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        findMissing findmissing = new findMissing();

        int[] nums = {1, 2, 3, 4, 6}; 
        System.out.println("Missing number: " + findmissing.findMissingInteger(nums));
    }
}
