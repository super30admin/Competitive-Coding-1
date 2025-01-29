// Time Complexity : O(logn) everytime we are reducing the search space by 1/2.
// Space Complexity : O(1) constant space complexity.
// Did this code successfully run on Leetcode : yes.
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
public class FindMissingNumber {
    public  int findMissing (String[] args) {
      int[] arr = new int[]{1, 2, 3, 4, 6, 7, 8};
      int low = 0;
      int high = arr.length-1;
      
      //used divide and conquer, to divide the array into half and checked if we can eliminate oen subarray.
      while(low<=high)
      {
          int mid = low + (high-low)/2;
            // if there are two elements left that means our missing element will be lying in between them so, we can return arr[mid] + 1;
          if(mid == low)
              return arr[mid]+1;
          //checking if the no of elements between the mid and range are equal to the actual elements present in the array,
          // if yes then that means we can eliminate that subpart, and if there is a difference then we explore that part further.
          if(arr[mid] - arr[low] == mid-low)
              low = mid;
          else
              high = mid;
              
      }
      
      return -1;
     
    }
  }
