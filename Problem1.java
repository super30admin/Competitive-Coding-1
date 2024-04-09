// Find Missing Number

// Time Complexity: O(logN), Space Complexity O(1)

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
      if(nums[0] != 0) return 0;
      if(nums[nums.length - 1] != nums.length) return nums.length;
        //[0,1,3]
        //[0,1,2,3,4,5,6,7,9]
        // 0,1,2,3,4,5,6,7,8

        //[0,2,3]
        // 0,1,2
        //[0,1,3,4,5,6,7,8,9]
        // 0,1,2,3,4,5,6,7,8
        int low = 0; int high = nums.length-1;

        while(low<=high){
        
        
        int mid = low + (high-low)/2;

            // mid is missing num start to miss
            if(nums[mid]!=mid){
                if(mid==0||nums[mid-1]==mid-1){
                    return mid;
                } else {
                    high = mid-1;
                }
            }
            // right
            else if(nums[high]!=high){
                low = mid+1;
            }
            //left
            else if (nums[low]!=low){
                high = mid-1;
            }
        }
        return -1;
    }
}