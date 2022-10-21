package S30_Codes.Competitive_Coding_1;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int mid = 0;

        while (end-start >= 2){
            mid = start + (end-start)/2;

            if( (nums[start]-start) != (nums[mid]-mid) )
                end = mid;
            else
                start = mid;
        }

        return ((nums[start]+nums[end])/2);
    }
}

class Solution{
    public static void main(String args[]){
        int[] arr = {3,4,5,6,8};
        MissingNumber m = new MissingNumber();
        System.out.println(m.missingNumber(arr));
    }
}
