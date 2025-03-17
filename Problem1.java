package binarysearch;

public class FindMissingElement {

    // [1,2,3,4,6,7,8]
    public static int findMissing(int[] nums) {
        int prev = nums[0];
        for(int i = 1 ; i < nums.length ; i++) {
            if(prev + 1 != nums[i]) {
                return nums[i] - 1;
            }
            prev = nums [i];
        }
        return -1;
    }

    public static int findMissingBinarySearch(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        // [1,2,3,4,6,7,8]
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(mid + 1 == nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 6, 7};
        int missing = findMissingBinarySearch(nums);
        System.out.println("Missing #" + missing);
    }
}

