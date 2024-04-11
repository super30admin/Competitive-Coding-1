class Solution {
    /**
        Thought Process -> Bit manipulation using XOR
        0 ^ 0 || 1 ^ 1 || n ^ n gives 0, so the missing number is the only one that is left in XORing, and the missingNumber ^ 0 gives missingNumber

        TC -> O(N)
        SC -> O(1)
     */
    public int missingNumber(int[] nums) {
        if(nums.length == 0 || nums == null)
            return -1;
        int missingNumber = nums.length;
        for(int i=0; i< nums.length; i++){
            missingNumber ^= i ^ nums[i];
        }
        return missingNumber;
    }
}
