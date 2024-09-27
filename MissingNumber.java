import java.util.Arrays;

public class MissingNumber {

    public static int missingNumber(int[] nums){
        Arrays.sort(nums);
        if(nums.length == 0 || nums == null) return -1;
        if (nums[0] != 1) return 1;

        int low = 0;
        int high = nums.length -1;
        int mid =0;

        while(high - low >= 2){
            mid = low + (high -low)/2;
            int midIdxDiff = nums[mid] - mid;
            int lowIdxDiff = nums[low] - low;
            int highIdxDiff = nums[high] - high;

            if(midIdxDiff != lowIdxDiff){
                high = mid;
            } else {
                low = mid;
            }
        }
        return (nums[low] + nums[high])/2;
    }

    public static void main(String[] args) {
        int[] nums = {1,2, 3, 5, 6, 7, 8};
        System.out.println( missingNumber(nums));
    }
}
