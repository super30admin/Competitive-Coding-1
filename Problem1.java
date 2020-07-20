// Time Complexity :O(log n)
//      n: number of elements
// Space Complexity :O( 1 )
//      Only two pointers
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no
public class Problem1 {

    /** find Missing element in sorted array */
    public static int findMissingElement(int[] arr, int length){
        // intial value
        int low = 0;
        int high = length-2; // since one element is missing

        // edge case
        if(arr[low]!=1) // start
           return 1;
        else if(arr[high] != length) // end
            return length;
        
        else{

            // using binary search approach find the pivot element
            while(low< high){

                // find mid
                int mid = low +(high-low)/2;

                // checking if mid and element at mid are equal so left side is increasing sequence
                if(mid == (arr[mid]-1))
                    low = mid+1;
                // if not then right is increasing sequence
                else
                    high = mid-1;
            }
            // pivot will be low as low == high
            return arr[low]-1;
        }
    }
    public static void main(String[] args) {
        //int arr[] = {1, 2, 3, 4, 6, 7, 8};
        int arr[] = {1, 2,3,5,6, 7};
        int length =  7;
        int answer = findMissingElement(arr, length);
        System.out.println("Found: "+ answer);
    }
}
