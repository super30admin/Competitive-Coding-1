// Time complexity - O(LogN)
// Space complexity - O(1)

public class Problem1 {
    public static int findMissingNum(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length == nums[nums.length - 1]) {
            System.out.println("No missing number");
            return -1;
        }
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int m_value = mid + 1;
            if (nums[mid] > m_value) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return nums[l] - 1;
    }

    public static void main(String[] args) {
        int[] nums = {};
        int[] nums1 = { 1, 2, 4, 5, 6 };
        int[] nums2 = { 1, 2, 3, 4, 5 };
        System.out.println(findMissingNum(nums));
        System.out.println(findMissingNum(nums1));
        System.out.println(findMissingNum(nums2));
    }
}
