// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Problem1 {
    public static void main(String[] args) {
        System.out.println(findMissingElement(new int[] { 1, 2, 3, 4, 5, 6, 7 }));
    }

    public static int findMissingElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        // play with low <= high; low + 1 or high - 1 can be returned
        while (low < high) {
            int mid = low + (high - low) / 2; // prevent integer overflow
            // integer number line; you can imagine it as a circle; if you exceed the
            // INT_MAX, it comes back to -2^31 and can give you a wrong value
            int midValue = nums[mid];

            if (mid + 1 == midValue) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        // if the said value does not exist
        if (nums[low] == low + 1) {
            return -1;
        } else {
            return nums[low] - 1;
        }
    }
}