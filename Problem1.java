//Find Missing Number in a sorted array starting from 1
// Time complexity - O(log(n)) n is the length of  the array
// Space complexity - O(1)
//Approach:
/*
 * As array always starts from 1 we know all element before missing will have difference of 1 between index and value,
 * using this fact we decide to go Left or Right in binary search. if nums[mid] == mid + 1, left side is sorted elso go right,
 * in the end return mid+1
 */
class Problem1 {
    public static int findMissing(int[] nums) {
        if(nums == null || nums.length < 1) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        if (high == nums[high] - 1) {
            return -1;
        }
        while(low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == mid + 1) { 
                low = mid + 1;
            } else { 
                high = mid - 1;
            }
        }
        return mid + 1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,5,6,7};
        int misssing = findMissing(nums);
        System.out.println(misssing);
    }
}
