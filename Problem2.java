/*
 * TO find the missing number in a sorted array
 * We need to find low, mid, high and do the value[low]-low and the same thing for high and middle
 * We need to compare the low and mid difference and they should be same if there is no missing number
 * Else the differences would not match for arr[low]-low and arr[mid]-mid
 * if matches then compare mid to high and move the low accordingly until we find the two points in between which the number is missing
 * then we do [num1+num2/2] and return the missing number
 * Edit: If the first and last number in arr are missing then you can modify the solution with

if (ar[0] != 1)
            return 1;
if (ar[size - 1] != (size + 1))
            return size + 1;
 */


 public class missingNum {
    public static int search(int arr[], int size)
    {
        int low = 0;
        int high = size-1;
        int mid = 0;
        while(high-low>=2)
        {
            mid = low+(high-low)/2;
            int midDiff = arr[mid]-mid;
            int lowDiff = arr[low]-low;
            int highDiff = arr[high]-high;
            if(midDiff!=lowDiff)
            {
                high = mid;
            }
            else if(midDiff!=highDiff)
            {
                low=mid;
            }
        }
        return (arr[low]+arr[high])/2;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,10};
        int size = arr.length;
        System.out.println("Missing number: "+ search(arr, size));
    }
}

