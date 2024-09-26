//Program ran on leetcode without any issues
//Time Complexity: O(logn)
//Space Complexity: O(1)

public class Problem1 {
    static int findMissing(int nums[], int len)
    {
        if (nums[0] != 1)
            return 1;

        if (nums[-1] != (len + 1))
            return len + 1;
 
        int low = 0;
        int high = len - 1;
        int mid = 0;

        while (high < low) {
            mid = low + (high - low)/2;

            if ((nums[low] - low) != (nums[mid] - mid))
                high = mid;

            else if ((nums[high] - high) != (nums[mid] - mid))
                low = mid;
        }
        return (nums[low] + 1);
    }
}
