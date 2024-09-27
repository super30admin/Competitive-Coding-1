// TC: O(n)
// SC: O(1)

class Solution {
    public int missingNumber(int[] nums) {
        int expectedSum = 0;
        int actualSum = 0;
        int n = nums.length;

        for(int i = nums.length - 1; i >= 0; i--) {
            expectedSum += n--;
            actualSum += nums[i];
        }

        return expectedSum - actualSum;
    }
}
