// Time Complexity : O(log(n))
// Space Complexity : O(1)
    //n is the size of the array being searched.

//You are given a continuous stream of natural numbers put in an array. Find the missing number if any.
//If there is no missing number return -1
public class Problem2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,8};
        System.out.println(findMissingNumber(arr));
        int[] arr2 = {1,2,3,4,5,6,7};
        System.out.println(findMissingNumber(arr2));
        int[] arr3 = {1,3,4,5,6,7,8};
        System.out.println(findMissingNumber(arr3));
    }
    
    private static int findMissingNumber(int[] arr)
    {
        int n = arr.length;
        int low = 0, high = n-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if (arr[mid]==mid+1)
            {
                //first subarray
                //missing number is present after the middle index, discard the left half array
                low = mid+1;
            }
            else
            {
                //second subarray
                if (mid==0)
                {
                    return 1;
                }
                int justPreviousNumber = arr[mid-1];
                if (justPreviousNumber==mid)
                {
                    //this is the missing number
                    return mid+1;
                }
                else
                {
                    //missing number is present before the middle index, discard the right half array
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}