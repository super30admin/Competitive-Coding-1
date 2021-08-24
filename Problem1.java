// Find Missing Element
// TIME: O(logn)
// SPACE: O(1)
// SUCCESS on LeetCode

class FindMissing {
    public int find(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] - mid > 1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left + 1;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 5, 6, 7, 8};
        FindMissing findMissing = new FindMissing();
        System.out.println(findMissing.find(nums));
    }
}