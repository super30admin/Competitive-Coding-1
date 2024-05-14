
/**
 * Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.
 * Examples:
 *
 * Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
 * Output : 4
 * * Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]

 * Output : 3
 */
class Problem1{
    public int missingNumber(int[] nums) {

        if(nums.length <=1 && nums[0] == 0){
            return 1;
        }else if(nums.length <=1 ){
            return 0;
        }
        int max = nums.length;
        int actual = 0;
        for(int i=0; i<= max; i++){
            actual+= i;
        }
        int diff = 0;
        for(int i=0; i< nums.length; i++){
            diff+= nums[i];
        }

        return actual-diff ;

    }

}
