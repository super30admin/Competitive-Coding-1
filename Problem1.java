public class Problem1 {

    // Time Complexity : O(log n)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    //Approach - if element at mid is not following the pattern (index = i, value = i+1), then check if prev element is
    //satisfying the pattern, in that case missing element is nums[mid]-1, else if prev element is also not satisfying
    //the pattern then search in left part for the missing element, otherwise in the right part.
    public static int findMissing(int[] nums) {
        int len = nums.length;
        int low = 0;
        int high = len-1;

        while(low <= high) {
            int mid = low + (high-low)/2;

            if(nums[mid] != mid+1 && (mid == 0 || nums[mid-1] == mid)) {
                return nums[mid]-1;
            } else if(nums[mid] != mid+1) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a= {1,2,3,4,6,7};
        int missing = findMissing(a);
        System.out.println(missing);
    }
}

