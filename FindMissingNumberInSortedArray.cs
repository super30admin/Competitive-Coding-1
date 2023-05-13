namespace LeetCodeSubmission.CompetitiveCoding1;

public class FindMissingNumberInSortedArray
{
    public int FindMissingNumber(int[] nums)
    {
        int missingNumber = Int32.MaxValue;
        
        int low = 0;
        int high = nums.GetLength(0) - 1;

        /*
         * if at ith index, we should have i+1 value, if not then i+1 value is missing!!
         */
        while (low <= high)
        {
            // chk missing number for low 
            if (nums[low] != low + 1)
            {
                missingNumber = Math.Min(missingNumber, low + 1);
            }
            // chk missing number for high
            if (nums[high] != high + 1)
            {
                missingNumber = Math.Min(missingNumber, high + 1);
            }
            
            // cal mid and chk for the mid
            int mid = (high - low) / 2 + low;
            if (nums[mid] != mid + 1)
            {
                missingNumber = Math.Min(missingNumber, mid + 1);
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        
        // return
        return missingNumber;
    }
}