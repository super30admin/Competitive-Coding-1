// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// using XOR we can campare the numbers and find the single number
// Your code here along with comments explaining your approach
class Solution {
    public int singleNumber(int[] nums) {
        int sum = 0;
        for( int num : nums ){
            sum ^= num;
        }
        return sum;
    }
}