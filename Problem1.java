// Time Complexity : O(log n)
// Space Complexity : O(1)


// Problem based on Binary Search
// Find Number missing in sorted array starting from 1

public class Problem1 {
    public static int searchMissing(int[] arr)
    {
        int low = 0;
        int high = arr.length - 1;
        int mid = low + (high - low) / 2;
        // [1, 2, 3, 4, 6]
        // [1, 2, 4, 5, 6, 7, 8, 9]
        while(low <= high)
        {
            mid = low + (high - low) / 2;
            if((arr[mid] != mid + 1) && ((mid == 0) || (arr[mid - 1] == mid)))
            {
                return mid + 1;
            }
            if(arr[mid] == mid + 1)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return mid + 1;
    }
    public static void main(String[] args)
    {
        // Test the function with an example array
        int[] nums = {1, 2, 3, 5, 6, 7, 8, 9};
        int missingNumber = searchMissing(nums);
        System.out.println("Missing Number: " + missingNumber);
        int[] nums2 = {1, 2, 3, 4, 6};
        int missingNumber2 = searchMissing(nums2);
        System.out.println("Missing Number: " + missingNumber2);
        // In order to cater to the index out of bounds error in the code below, we add the condition mid == 0
        int[] nums3 = {2, 3, 4, 5, 6};
        int missingNumber3 = searchMissing(nums3);
        System.out.println("Missing Number: " + missingNumber3);
        int[] nums4 = {1, 2, 3, 4, 5, 6, 8};
        int missingNumber4 = searchMissing(nums4);
        System.out.println("Missing Number: " + missingNumber4);
    }
}
