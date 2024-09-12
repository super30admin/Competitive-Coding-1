//Time Complexity:O(Log N)
//Space Complexity:O(1)
//Finding the Missing Number from the array
public class MissingNumber{
     public static int MissingSearch(int[] nums)
     {
         int low=0;
         int high = nums.length - 1;
         while ((low-high > 2)
         {
             int mid = low + (high -low)/2;
             if(nums[mid]-mid != nums[low] - low)
             {
                 high = mid;
             }
             else
                 low = mid;
         }
         return (nums[low] + nums[high])/2;
     }
}
