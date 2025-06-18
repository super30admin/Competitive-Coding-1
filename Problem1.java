class solution {

    static int missingNumber(int[] nums) {
        int n = nums.length + 1;

        // Iterate from 1 to n and check
        // if the current number is present
        for (int i = 1; i <= n; i++) {
            boolean found = false;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    found = true;
                    break;
                }
            }

            // If the current number is not present
            if (!found)
                return i;
        }
        return -1;
    }
}
