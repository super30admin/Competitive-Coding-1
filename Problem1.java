
//Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.
//Input : arr[] = [5, 2, 3, 1, 6, 7, 8]
//Output : 4

//Time Complexity: O(N) where N is length of input array
//Space complexity: O(1)

public class Problem1{
    public static void main(String args[]){
        int[] nums = {1, 2, 3, 4, 5, 6, 8, 9};
        System.out.println(findMisingNumber(nums));
    }

    private static int findMisingNumber(int[] nums){
        if(nums == null || nums.length == 0){
            return -1;
        }

        for(int i=0; i<nums.length; i++){
            int idx = Math.abs(nums[i]) - 1;

            if(idx < nums.length && nums[idx] > 0){
                nums[idx] = -1 * nums[idx];
            }
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }

        return nums.length;
    }
}