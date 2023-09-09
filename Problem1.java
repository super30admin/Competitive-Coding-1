// Interview Problem: Find Missing Number in a sorted array

//Source Link: https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/

//TC: O(logn)
//SC: O(1)

class Solution {
    public int search(){
        int [] nums = {1,2,3,5,6,7,8};
        //int [] nums = {1,3};

        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(mid >0 && nums[mid] - nums[mid-1]!=1){
                return nums[mid]-1;
            }
             if(mid< nums.length - 1 && nums[mid+1]- nums[mid]!=1){
                return nums[mid]+1;
            }

            if(nums[mid] - mid != nums[low] - low){
                high = mid -1;
            }else{
                low = mid+1;
            }
        }

        return -1;
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        int result = sol.search();
        System.out.println("Here is the result - "+result);
    }
}