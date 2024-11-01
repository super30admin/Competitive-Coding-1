class Problem1 {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int low = 0, high =n-1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid]  != mid+1) {
                high = mid ;
            } else {
                low = mid+1;
            }

        }
        return low+1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 7, 8};
        int res = missingNumber(arr);
        System.out.println(res);
    }
}