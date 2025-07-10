
public class Solution {
    public int findMissing(int[] nums) {
        
        int low=0;
        int high= nums.Length-1;
        while(low<=high)
        {
            if(high-low ==1)
            {
                return Math.Abs(nums[high]+nums[low]/2);
            }
            var mid = Math.Abs(low+(high-low)/2);
            var leftDifference = nums[low]-low;
            var midDifference = nums[mid]-mid;
            var highDifference = nums[high]-high;
            if(leftDifference != midDifference)
            {
                high = mid-1;
            }
            else if(midDifference!=highDifference)
            {
                low = mid+1;
            }

        }
    }
}
