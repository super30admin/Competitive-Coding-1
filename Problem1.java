
/**
// Time Complexity : O(logn) 
// Space Complexity : O(n) (size of array)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :N/A
 */
public class Main {
    public static void main(String[] args) {
        
        int[] arr = {1, 2, 3, 4, 6, 7, 8};
        
        int low = 0, high = arr.length - 1;
        
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if((arr[mid]-mid)!=(arr[high]-high))
            {
                low = mid;
                if((high-low)==1)
                    break;
            }else
            {
                high=mid;
            }
        }
        if((low+1)!=arr[low])
            System.out.println(low+1);
        else
            System.out.println(high+1);
        
        
    }
}