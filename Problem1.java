// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// take the sum of all numbers till the count of the array, then subtract each number from that and return the missing number
// Your code here along with comments explaining your approach
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (n * ( n + 1)) / 2;
        for( int num : nums ){
            sum -= num;
        }
        return sum;
    }
}