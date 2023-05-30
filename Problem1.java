
import java.util.*;
class Solution
{
    public static int findMissingNumber(int[] arr, int n) {
        int high = arr.length -1;
        int low =0;
        int mid = 0;

        while(low<=high)
        {
            mid = low + (high-low)/2;
            if(mid > 0 && arr[mid] - arr[mid-1] != 1)
            {
                return arr[mid] - 1;
            }
            else if (mid < n && arr[mid+1] - arr[mid] != 1)
            {
                return arr[mid] + 1;
            }
            else if (mid > 0 && arr[mid] - arr[low] != mid -low)
            {
                high = mid;
            }
            else
            {
                low = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr = {1,3,4,5,6,7,8};
        int i = findMissingNumber(arr, arr.length-1);
        System.out.println("Return value is"+ i);

        
    }
}