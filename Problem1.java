//Time complexity: O(n)
//Space complexity: O(1)
//Ran on leetcode


class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum=sum+nums[i];
        }
        int totalsum = (n*(n+1))/2;
        return totalsum - sum;
    }
}