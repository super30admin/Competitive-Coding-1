// Time Complexity : O(logn) where n is the size of array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class GFG {
    public static void main (String[] args) {
        int [] nums = {1,3,4,5,6,7,8};

        int start = 0;
        int end = nums.length;

        // for(int i=0;i<end;i++){
        //     if(nums[i]!=i+1){
        //         System.out.println("Missing element is "+(i+1));
        //     }
        // }

        while(start<end){
            int mid = (start + end)/2;
            if(nums[mid]==mid+1){//go to the right side of array
                start = mid+1;
            }
            else if(nums[mid]!=mid+1 && nums[mid-1]!=mid){
                end = mid-1;
            }
            else{
                System.out.println("Missing element is "+(mid+1));
                break;
            }
        }
    }
}