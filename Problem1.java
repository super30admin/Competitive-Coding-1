
public class Problem1 {

    public static void main(String[] args) {
        System.out.println(findMissingByMe(new int[] { 1, 2, 4, 5 })); // 3
        System.out.println(findMissingByMe(new int[] { 2, 3, 4, 5 })); // 1
        System.out.println(findMissingByMe(new int[] { 1, 2, 3, 4 })); // 5

        System.out.println(findMissingByJaspinder(new int[] { 1, 2, 4, 5 })); // 3
        System.out.println(findMissingByJaspinder(new int[] { 2, 3, 4, 5 })); // 1
        System.out.println(findMissingByJaspinder(new int[] { 1, 2, 3, 4 })); // 5
    }

    private static int findMissingByMe(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums[0] != 1)
            return 1;

        if (nums[nums.length - 1] != nums.length + 1)
            return nums.length + 1;

        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if ((nums[mid] - mid) > 1) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[low] - 1;
    }

    private static int findMissingByJaspinder(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        if (nums[0] != 1) {
            return 1;
        }
        if (nums[n - 1] != n + 1) {
            return n + 1;
        }
        int low = 0;
        int high = n - 1;
        while ((high - low) > 1) {
            int mid = (low + high) / 2;
            if ((nums[low] - low) != (nums[mid] - mid))
                high = mid;
            else if ((nums[high] - high) != (nums[mid] - mid))
                low = mid;
        }
        return (nums[low] + nums[high]) / 2;
    }

}