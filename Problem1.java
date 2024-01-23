// TC- O(n)
// SC- O(1)

class Solution {
    public int missingNumber(int[] nums) {
        int sum=0;
        int n=nums.length;
        int sumN= n*(n+1)/2;
        for(int num:nums){
            sum=sum+num;
        }
        int number= sumN-sum;
        return number;
    }
}
