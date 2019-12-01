// Time Complexity : O(N) 
// Space Complexity : O(Constant).
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : Nope.


// Your code here along with comments explaining your approach
class MissingElement {
    public int missingElement(int[] nums, int k) {
        int i = 0, K = 0;
        int miss = Integer.MIN_VALUE;
        while(i < nums.length-1 && K + nums[i+1] - nums[i] - 1 <= k){
                int start = nums[i] + 1;
                int end = nums[i+1];
                if(start < end){
                    miss = end-1;
                    K += end - start;
                }
            i++;
        }
        if(K == k){return miss;}
        if(i < nums.length - 1 && K + nums[i+1] - nums[i] - 1 > k){
           return nums[i] + k - K;
        }
        miss = nums[nums.length-1]+1;
        K++;
    return miss+k-K;
    }
}