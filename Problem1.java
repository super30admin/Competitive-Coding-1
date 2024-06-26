class MissingElement {
    public static int missElement(int[] nums) {
        if (nums[0] == 2)
            return 1;

        int left = 0, right = nums.length - 1, mid;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (mid == nums.length - 1 || nums[mid + 1] != nums[mid] + 1)
                return nums[mid] + 1;
            else if (mid + 1 == nums[mid])
                left = mid + 1;

            else
                right = mid - 1;
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        int x = missElement(nums);
        System.out.println(x);
    }
}