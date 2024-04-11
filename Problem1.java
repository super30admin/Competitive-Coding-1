//Missing number in sorted array
//import java.io.*;
class Problem1
{
    public static int search (int arr[], int size)
    {
        int low = 0, high = size - 1, mid = 0;
        while(high - low >= 2)
        {
            mid = low + (high - low) / 2;
            int midIdxDiff = arr[mid] - mid;
            int lowIdxDiff = arr[low] - low;
            int highIdxDiff = arr[high] - high;
            if(midIdxDiff != lowIdxDiff){
                high = mid;
            }else if(midIdxDiff != highIdxDiff){
                low = mid;
            }
        }
        return (arr[low] + arr[high]) / 2;
    }
    public static void main (String[] args){
        int arr[] = {1, 2, 3, 4, 5, 6, 8};
        int size = arr.length;
        System.out.println("Missing number is: " + search(arr, size));
    }     
}
