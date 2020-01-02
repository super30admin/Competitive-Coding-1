// Time Complexity : O(n) maybe unsure of Internal Java Streams Working but guessing it scans linearly
// Space Complexity : Not sure. Need to learn how to calculate.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, Used a bit different but successful approach

import java.util.stream.IntStream;

class MissingNumber {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        //Find the number n so we can apply the sum formula for integers
        int n = nums.length + 1;
        //What should be the sum minus what is the sum now, is the answer
        return (n * (n - 1))/2 - IntStream.of(nums).sum();
    }
}
