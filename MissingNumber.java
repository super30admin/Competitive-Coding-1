// Time Complexity : O(logN)
// Space Complexity :0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
         public int missingNumber(int[] nums) {
        
        Arrays.sort(nums);
        
        int low=0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = (low+high)/2;
            
            if(mid==nums[mid]){
                low= mid+1;
            }else{
                high=mid-1; 
                         }
        }
        return low;
    }
}
