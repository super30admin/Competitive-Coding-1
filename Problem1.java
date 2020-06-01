import java.util.*;

class Solution {

      // Time Complexity : O(log(length of array))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this : 


    public static int missingNumber(int[] nums) {
        int low = 0;int high = nums.length-1;
        if(nums == null || nums.length == 0) return 0;
        while(low<high){
            int mid = low +(high-low)/2;                                                      
            if(nums[mid]==(mid+1)){ // We can skip the element if the codition i satisfied.
                low = mid+1;
            }
            else{//We need the element whichever is not satisfying the condition
                high = mid;
            }
        }
        return low+1;
    } 

 

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n-1];
        for(int i=0;i<n-1;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(missingNumber(nums));
    } 


}
