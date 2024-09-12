// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
public class Main {
    public static int findMissingNumber(int[] nums){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(mid>=0 && nums[mid]-nums[mid-1] ==2){
                return nums[mid]-1;
            }
            else if(nums[mid] - mid < 2){
                low = mid+1;
            }
            else {
                high = mid -1;
            }
           
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,5,6};
        //23456-> 1
        int missingNumber = findMissingNumber(arr);
        System.out.println("Missing number is:" + missingNumber);
    }
}
