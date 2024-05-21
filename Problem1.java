//Problem Name: Interview Problem: Find Missing Number in a sorted array

public class Problem1 {

    // TC - O(log n)
    // SC - O(1)

    public static int findMissingNo(int[] nums) {

        if(nums == null || nums.length == 0) {
            return -1;
        }

        int low =0;
        int high = nums.length-1;

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(nums[mid] != mid+1) {
                if(mid == low || nums[mid-1] == mid)
                    return mid+1;
                else
                    high = mid-1;
            }

            else {
                low = mid+1;
            }
        }

        return low+1;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Missing No = " + findMissingNo(nums));
    }
}
