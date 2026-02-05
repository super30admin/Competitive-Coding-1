class Solution {
    public int findPairs(int[] nums, int k) {
        int i = 0, j = 1;
        int count =0 ;
        int sum = Integer.MIN_VALUE;
        Arrays.sort(nums);

        while(j < nums.length && i<nums.length-1){
            int diff = nums[j] - nums[i];

            if(diff == k && sum != nums[i] + nums[j]){
              sum = nums[i]+nums[j];
              count++;
              i++;
              j++;
            }
            else if(diff < k) j++;
            else i++;

            if(i == j) j++;
        }
    return count;
    }
}