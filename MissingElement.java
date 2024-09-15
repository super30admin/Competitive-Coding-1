// Time Complexity : O(N) and O(Log(N)) solution from online.
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
	
	  int missing(int index, int[] nums){
        return nums[index] - nums[0] - index;
    }
    public int missingElement1(int[] nums, int k) {
        int n = nums.length;
        int last = missing(n-1,nums);
        if(k > last){
            return nums[n-1] + k-last;
        }
        int left = 0, right = n-1, mid;
        while(left != right){
            mid = left + (right-left)/2;
            if(missing(mid,nums)<k){
                left = mid +1;
            }else{
                right = mid;
            }
        }
    return nums[left-1]+k-missing(left-1,nums);
    }
}