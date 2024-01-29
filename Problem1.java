class Problem1 {
    public static int findMissingNumber(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            // Element at position mid is the missing element
            if (mid != 0 && (nums[mid] - nums[mid - 1]) != 1)
                return nums[mid] - 1;

            if (nums[mid] - nums[0] == mid) {
                // Current element at correct position, Search in right
                l = mid + 1;
            } else {
                // Search in left
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { -3 };
        System.out.println(findMissingNumber(arr));
    }
}
