//Binary Search is applied
//Time Complexity: O(log N)

public class MissingNumber
{
    public static int missing(int arr[])
    {
        if(arr==null || arr.length==0)
        {
            return -1;
        }

        int low = 0,high = arr.length-1;
        int mid=-1;
        while(low<=high)
        {
             mid = low + (high - low)/2;

            if((arr[low]-low)!=(arr[mid]-mid))
            {
                high = mid;
            }
            else if((arr[high]-high)!=(arr[mid]-mid))
            {
                low = mid;
            }
        }
        return arr[low] + 1;
    }


    public static void main(String args[])
    {
        int arr[] = {1,2,4,5};
        System.out.println(missing(arr));
    }
}
