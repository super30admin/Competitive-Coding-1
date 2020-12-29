/*
Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.
*/

/*
time complexity : O(log n),n is the number of elements in the given array
space complexity : O(1)


*/
class MissingElement{
    public int missingNumber(int [] nums){
        //base conditions
        if(nums.length == 0 || nums == null){
            return -1;
        }
        
        int low = 0;  
        int high = nums.length-1;
        
        //Binary Search on nums array 
        
        
        while(high - low > 1){
               
               int mid = low + (high - low) / 2;
               
               if(nums[mid] - mid != nums[low] - low){ 
                   //go to the left side of the array of bringing high pointer to mid
                   high = mid;
               }else{
                   low = mid;
               }
        }
        
        return (nums[low]+nums[high])/2;
    }
}
