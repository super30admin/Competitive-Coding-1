import java.util.Arrays;
class MissingNumber {

    /*
    Time complxity: O(n log n)
    Space complexity: O(1)
    */
    private int missingNum(int[] nums) {

        // sort the nums array
        Arrays.sort(nums);
        int l = 0;
        int h = nums.length - 1;

        // check if h-l difference is greater than or equal to 2
        while(h - l >= 2) {
            int m = l + (h - l) / 2;
            // calculate the leftind, rightind, midind difference
            int leftind = nums[l] - l;
            int rightind = nums[h] - h;
            int midind = nums[m] - m;

            // if the midind and the leftind are not equal then move onto left sub-array
            if(midind != leftind) {
                h = m;
            }
            // if the midind and the rightind are not equal then move onto right sub-array
            else if (rightind != midind) {
                l = m;
            }
        }
        // return the missing number between l and h
        return (nums[l] + nums[h]) / 2;
    }

    public static void main(String[] args) {
        MissingNumber mNumber = new MissingNumber();
        int[] arr = {2,1,5,3,6,7,8};
        System.out.println(mNumber.missingNum(arr));
    }

}