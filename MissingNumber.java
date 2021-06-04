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

    public static void main(String args[])
    {
        MissingNumber obj = new MissingNumber();
        int[] nums = {1,2,3,4,5,6,8,9};
        System.out.println(obj.MissingSearch(nums));
    }
}

//time complexity is O(logN)
//space complexity is O(1)
