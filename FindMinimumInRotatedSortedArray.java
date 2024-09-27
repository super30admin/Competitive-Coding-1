/**
 * Time complexity is O(log n)
 * Space complexity is O(1)
 * Did this code successfully run on Leet code : Yes
 * Any problem you faced while coding this : No
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        int min = getMinimum(nums);
        System.out.println(min);
    }

    private static int getMinimum(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while(low<=high){
            if(nums[low] <= nums[high]){
                return nums[low];
            }

            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid] <= nums[mid - 1])  &&
                    (mid == nums.length-1 || nums[mid] <= nums[mid + 1])){
                return nums[mid];
            }
            else if(nums[low] <= nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return 123456;
    }
}
