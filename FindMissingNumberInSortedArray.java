public class FindMissingNumberInSortedArray {
    public static int missingNumber(int[] nums) {
        
        int low = 0;
        int high = nums.length - 1;
        
        while((high - low) > 1) {
            int mid = low + (high - low) / 2;
            
            if(nums[mid] - mid != nums[low] - low) 
                high = mid;
            else if(nums[mid] - mid != nums[high] - high)
                low = mid;
        }
        return (nums[low] + nums[high]) / 2;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 8};
        System.out.println(missingNumber(nums));
    }
}