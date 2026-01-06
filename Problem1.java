//Problem: Finding missing number in a sorted array

class Main {
    /**
     * Approach 1: This method uses the property that in a sorted array starting from a specific value,
     * the difference between the element and its index (nums[i] - i) should remain constant.
     * If a number is missing, this difference will change for all elements after the gap.
     *
     * Time Complexity: O(log N) - Standard binary search where the search space is halved in each step.
     * Space Complexity: O(1) - Only a few variables are used regardless of input size.
     */

    private static int search(int[] nums){

        int low = 0;
        int high = nums.length -1;

        while(high - low > 1){
            int mid = low + (high - low)/2;
            if(nums[mid] - mid == nums[low] - low){
                low = mid;
            }else{
                high = mid;
            }
        }
        return (nums[low] + nums[high])/2;
    }

    /**
     * Approach 2 : This method checks if the current element (arr[mid]) is exactly one greater
     * than its predecessor. If it is, the sequence is intact up to that point, so we
     * search the right half. Otherwise, the break occurred earlier, so we search the left.
     *
     * Time Complexity: O(log N) - Each iteration reduces the search range by half.
     * Space Complexity: O(1) - Constant space used for pointers.
     */

    private static int search2(int[] arr){

        int low = 0;
        int high = arr.length-1;

        while(high - low > 1){
            int mid = low + (high - low)/2;
            if(arr[mid] == arr[mid - 1] + 1){
                low = mid;
            }else{
                high = mid;
            }
        }


        return arr[low]+1;
    }
    public static void main(String[] args) {
        int[] nums = { 2,3,4,5,6,7,9};

        System.out.println("Missing number: " + search(nums));
        //System.out.println("Missing number: " + search2(nums));
    }
}

