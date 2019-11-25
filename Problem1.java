
//Time Complexity : O(n)
//space : O(1)
//leetcode : yes

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        //check what should be the actual sum of n integers
        int sum= n*(n+1)/2;
        //calculate current array sum and subtract from orignal
        for(int i=0;i<n;i++)
        {
            sum-=nums[i];
            
        }
        return sum;
    }
}
