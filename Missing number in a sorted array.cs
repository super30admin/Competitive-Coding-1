/*
  Time complexity: O(log n)
  Space complexity: O(1)

  Code ran successfully: Yes

  Approach: The numbers are sorted and increase montonically. Checking if the middle index has the middle element helps us eliminate half of the array repeatitively leading us to the result of low+1.
*/

public class Solution {
    public int missingNumber(int arr[]) {
        
        int n= arr.Length;
        
        int low=0;
        int high=n-1;
        
        if(arr==null || arr.length==0) return 1;
        if(arr[low]!=1) return 1;
        if(arr[high]==n) return n+1;
        
        while(low<high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]!=mid+1)
            {
                high=mid;
            }
            else
            {
                low =mid+1;
            }
        }
        return low+1;
    }
}
