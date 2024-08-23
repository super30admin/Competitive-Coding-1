//Time Complexity : O(log N) - Using Binary Search
//Space Complexity : O(1)
//Have you faced any problem while running this code on leetcode : No
//Did this code run successfully on leetcode: Yes
class Problem1 {
    public int missingNumber(int[] nums) {
        // Arrays.sort(nums);
        // if(nums[0] != 0) return 0;
        // if(nums[nums.length - 1] != nums.length) return nums.length;
        // int low = 0, high = nums.length-1;
        // int ans = -1;
        // while(low <= high) {
        //     int mid = low+(high-low)/2;
        //     if(nums[mid] != mid) ans = mid;
        //     if(nums[mid] > mid){
        //         high = mid-1;
        //     } else {
        //         low = mid+1;
        //     }
        // }
        // return ans;
        int low = 0;
        int high = nums.length - 1;
        while(high - low > 2) {
            int mid = low + (high - low)/2;
            int midDiff = nums[mid] - mid;
            int lowDiff = nums[low] - low;
            int highDiff = nums[high] - high;
            if(midDiff != lowDiff) {
                high = mid;
            } else if (midDiff != highDiff) {
                low = mid;
            }
        }
        return (nums[low] + nums[high])/2;
    }
}
