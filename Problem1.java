/* Provide an array of n-1 integers in the range of 1 to n with no 
duplicates in list, One of the integers is missing in the list. 
Write a code to find the missing integer. */

//Time Complexity - O(logN)
//Space Complexity - O(1)
/* Approach - use length as the crux as all elements are consecutive 
and sorted. Also at every point check whether element surounding mid is 
missing*/

class Mock1{
    public static int missingValue(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while(left<=right){
            int mid = left + (right-left)/2;

            /*Everytime it arrives at mid it checks whether there
             is something missing between mid and mid+1 or mid and mid-1 
             mid>left and mid<right check is put to ensure index does not go out of bound
             e.g. {5,7} as input*/
            if(mid>left && (nums[mid]-nums[mid-1])==2){
                return nums[mid]-1;
            }
            if(mid<right && (nums[mid+1]-nums[mid])==2){
                return nums[mid]+1;
            }
            /*Here it checks whether the length between mid and left index 
            and the diff between mid element and left element is same
            if yes then element missing on the right side else missing on the 
            left side */
            if((mid-left)==(nums[mid]-nums[left])){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return 3535;
    }

    public static void main(String[] args){
        int[] arr = {5,7};
        int temp = Mock1.missingValue(arr);
        System.out.println(temp);
    }
}
