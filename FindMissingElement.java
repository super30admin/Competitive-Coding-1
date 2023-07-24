// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
public class FindMissingElement {

    static int findElement(int[] nums)
    {
        int low = 0, high = nums.length-1;
        int result = -1;

        if(nums == null || nums.length == 0 )return -1;

        while(low <= high)
        {
            int mid = low + (high - low)/2;
            int firstElement = nums[low];
            int indexDiff = firstElement - low - 1;

            if(mid!=high && nums[mid+1]-nums[mid] != 1)
            {
                return nums[mid] + 1;

            }else if(mid!=low && nums[mid]-nums[mid - 1] != 1)
            {
                return nums[mid] - 1;
            }
            else if(nums[mid] == mid+indexDiff+1)
            {
                low = mid + 1;
            }else {
                high = mid - 1;
            }

        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {5,7};
        System.out.println(findElement(arr));

    }



}
