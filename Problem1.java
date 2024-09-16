// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



public class Main {
    public static int binarySearch(int[] nums){
        int size = nums.length;
        if(nums[0] != 1)
        {
            return 1;
        }
        else if(nums[size-1] != size+1)
        {
            return size+1;
        }
        
        int low = 0, high = size-1;
        
        while(high - low > 1)
        {
            int mid = low + (high-low)/2;
            if(nums[low]-low != nums[mid]-mid)
            {
                high = mid;
            }
            else if(nums[high]-high != nums[mid]-mid)
            {
                low = mid;
            }
        }
        return nums[low]+1;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,7,8};
        System.out.println(binarySearch(arr));
    }
}