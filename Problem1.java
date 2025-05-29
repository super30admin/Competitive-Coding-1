/*
Given a sorted array arr[] of n-1 integers, these integers are in the range of 1 to n. There are no duplicates in the array. One of the integers is missing in the array. Write an efficient code to find the missing integer.
Examples:

Input : arr[] = [1, 2, 3, 4, 6, 7, 8]
Output : 5
Explanation: The missing integer in the above array is 5

Input : arr[] = [1, 2, 3, 4, 5, 6, 8, 9]
Output : 7
Explanation: The missing integer in the above array is 7
 */


class Problem1 {


    /*
     *
     * time L: O (lon(n))
     * space : O(1)
     *
     * */

    private static int search(int[] nums){
        int low = 0;
        int high = nums.length - 1;

        int mid = low + (high - low) / 2;

        while(low <= high){

            mid = low + (high - low) / 2;

            // if the mid is correctly placed - go to the right to find missing element
            if(nums[mid] == mid + 1){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return mid + 1;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3, 4, 6, 7, 8};


        System.out.println(search(nums));
    }





}
