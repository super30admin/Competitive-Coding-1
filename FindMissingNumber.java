
class FindMissingNumber {
    public int missingNumber(int[] nums) {
        int m=nums.length,s1=0;
        int sum=(m*(m+1))/2;
        for(int num:nums){
            s1+=num;
        }
        sum=sum-s1;
        return sum;


        
    }
}