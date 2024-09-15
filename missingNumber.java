// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int missingNumber(int[] nums) {
        if(nums==null || nums.length<=0) return -1;
        int n= nums.length;
        int expectedSum = (n*(n+1))/2;
        int actualSum=0;
        for (int i=0; i<= n-1; i++){
            actualSum += nums[i];
        }
        return expectedSum-actualSum;
    }
}