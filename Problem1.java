import java.util.*;

//Time O(logN)
//Space O(1)
public class Problem1
{
    public static int BinarySearch(int[] ar)
    {
        int low = 0 , high = ar.length-1;
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if(low == mid && ar[mid] != mid+1)
            {
                return mid+1;
            }
            if(ar[mid] != mid+1)
            {
                high = mid;
            }
            else
            {
                low = mid+1;
            }
        }
        return ar.length+1;
    }
    public static void main(String[] args)
    {
        int ar[] = {1,2,4,5,6,7,8};
        int i = BinarySearch(ar);
        System.out.println("Missing number : "+i);
    }
}