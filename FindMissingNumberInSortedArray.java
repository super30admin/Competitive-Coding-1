import java.util.Arrays;

// Time Complexity : O(logn)
// Space Complexity : O(1)

public class FindMissingNumberInSortedArray {

    public int search(int nums[])
    {
        if(nums == null || nums.length == 0)
            return -1;


        int low = 0 , high = nums.length-1;

        while((high-low) >= 2)
        {   
            int mid = low + (high-low)/2;

            int midIdxDiff = nums[mid]-mid;
            int lowIdxDiff = nums[low]-low;
            int highIdxDiff = nums[high]-high;

            if(midIdxDiff != lowIdxDiff) // value missing on left side
            {
                high = mid;
            }
            else //if(midIdxDiff != highIdxDiff) // value missing on right side
            {
                low = mid;
            }
        }

        return (nums[low] + nums[high])/2; // missing number is always mid of two numbers
    }


    public static void main(String[] args) {
        
        FindMissingNumberInSortedArray obj = new FindMissingNumberInSortedArray();
        int nums[] = new int[] {1,2,3,5,6,7,8};
        int val = obj.search(nums);
        System.out.println("Missing num from " + Arrays.toString(nums) + " is " + val);
    }

}