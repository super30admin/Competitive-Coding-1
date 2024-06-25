public class Problem1 {
    //Problem1 =  https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/
    private static int findMissingBinary(int[] nums) { //O(logN)
        int length = nums.length;
        int low = 0;
        int high = length;

        if(nums[0] != 1) return 1; //missing first value
        if(nums[length-1] == length) return length + 1; //missing last value

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] != mid + 1 && nums[mid-1] == mid) { //if mid-value is not correct but mid-1 is correct
                return mid+1;
            }
            else if(nums[mid] != mid + 1 ) {
                high = mid-1;
            }
            else  {
                low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,5,6,7,8};
        System.out.println("Binary missing value is " + findMissingBinary(nums));
    }
}
