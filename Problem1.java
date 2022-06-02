// Time Complexity :O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Main {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 5, 6, 7, 8, 9, 10, 11 };
        int a = search(arr);
        System.out.print(a);
    }

    public static int search(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (high - low >= 2) {
            mid = low + (high - low) / 2;
            if (nums[low] - low != nums[mid] - mid) {
                high = mid;
            } else if (nums[mid] - mid != nums[high] - high) {
                low = mid;
            }

        }
        return nums[low] + 1;
    }

}
