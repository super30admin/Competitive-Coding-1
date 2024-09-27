//Time Complexity: O(logN)
//Space Complexity: O(1);
public class HelloWorld{

    private static int missingElement(int[] nums){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high)
        {
            int mid = low + ((high - low) / 2);
            if(nums[mid + 1] != nums[mid] + 1) return nums[mid] + 1;

            else if(nums[mid - 1] != nums[mid] - 1) return nums[mid] - 1;

            else if((nums[mid] - nums[low]) == (mid - low)) low = mid + 1;

            else high = mid - 1;
        }
        return 0;

    }
    public static void main(String []args){
        int[] nums = {1, 2, 3, 4, 5, 6, 8, 9};

        System.out.println(missingElement(nums));


    }
}
