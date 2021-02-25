// Find the Missing Number in a sorted array
// Time Complexity : O(log n)
// Space complexity : O(1)

class Solution {
    public int missingNumber(int[] nums) {
        if(nums.length == 0) return 0;
        int left = 0,right = nums.length-1;
      // Using binary search to compare if the elements and their index match
      // and find the missing number using the index
        while(left<=right){
            int mid = left+(right -left)/2;
            if(nums[mid] != mid)
                right = mid-1;
            else left = mid+1;
        }
        return left;
    }
}
