// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NO, ran it on leetcode playground
// Any problem you faced while coding this : didnot get the idea of checking the difference, proceeded with hints


// Your code here along with comments explaining your approach in three sentences only
/*
 * Use Binary search, Maintain the differences of each element in the array and its index
 * If low_diff and mid_diff is same then there is no missing element, if not then there exists the missing element
 * Shift the low and high to mid based on differnce, continue with BS approach
 */
class Solution {
    
    public  static int findMissing(int[] arr){
        int low =0;
        int high = arr.length -1;
        while(high-low > 1){
            int mid = low+(high-low)/2;
            int low_diff = arr[low]-low;
            //int high_diff = arr[high] - high;
            int mid_diff = arr[mid] - mid;
            if(low_diff == mid_diff)
                low=mid;
            else
                high=mid;
            
        }
        return arr[low]+1;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6,7,8,9};
        System.out.println(findMissing(arr));
        
    }
}