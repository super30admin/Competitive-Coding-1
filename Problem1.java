// [1, 2, 3, 4, 6, 7, 8]

// Time complexity : O(logn)
// Space complexity : O(1)
class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.helper(new int[]{1, 2, 3, 4, 6, 7, 8}));
    }

    private int helper(int[] input) {

        // null condition
        if(input.length == 0) {
            System.out.println("No elements in the array");
        }

        int low = 0, high = input.length - 1;

        while(low <= high) {

            int mid = low + (high - low)/2;

            // element condition
            if(input[mid] - mid == 2) {
                return mid + 1;
            }else if(input[mid] - mid == 1) {
                // element on the right side
                // System.out.println(low + " " + "low")
                low = mid;
            } else {
                // element on the left side
                high = mid;
            }
        }

        return -1;
    }
}
