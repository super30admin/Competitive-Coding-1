using System;
namespace Algorithms
{
    public class FindMissingNumber
    {

        public int SearchMissingNumber(int[] nums)
        {
            if (nums.Length == 0) return -1;
            int low = 0, high = nums.Length - 1;
            int mid = 0;

            while (high- low >=2)
            {
                mid = low + (high - low) / 2;

                int midIndexDiff = nums[mid] - mid;
                int lowIndexDiff = nums[low] - low;

                    if (midIndexDiff != lowIndexDiff)
                    {
                        high = mid;
                    }
                    else
                    {
                        low = mid;
                    }


            }
            return (nums[high] + nums[low])/2;

        }
    }
}
