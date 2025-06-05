public class Problem1 {

    public static int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid + 1 == nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1 ;
            }
        }
        return left + 1; // Because values are from 1 to n instead of 0 to n-1
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 7, 8};
        System.out.println(missingNumber(arr));  // Output: 5
    }
}