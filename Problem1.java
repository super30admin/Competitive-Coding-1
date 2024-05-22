/**
 *
 * The given array is sorted and one element is missing.
 * If a number is missing on left side then there will be difference between the value and idex is not same.
 *
 * Time Complexity : O(log(n)
 * Space Complexity : O(1)
 *
 */
class MissingNumber {
    public static int missingNumber(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;
        if(nums[0]!=1)
            return 1;
        if (nums[nums.length - 1] != (nums.length + 1))
            return nums.length + 1;
        int l =0;
        int h =nums.length-1;
        while((h-l)>1){
            int m = l+(h-l)/2;
            if(nums[l]-l!=nums[m]-m){
                h = m;
            }else if (nums[m]-m != nums[h]-h){
                l = m;
            }
        }
        return nums[l]+1;
    }
}
class Problem1{
    public static void main(String[] args) {
        int[] a = {1,2,3,5,6,7,8};
        System.out.println(MissingNumber.missingNumber(a));
    }
}