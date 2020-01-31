/*Find missing number in sorted array*/

// Time Complexity : 0(logN) (binary search)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// as we know array is sorted, we will consider the binary search here
//we will initialise low, mid and high pointers and find the difference
//between particular value and index (value resides in) for low, high and mid
//we will compare low(diff) with mid(diff) and mid(diff) with high(diff)
//see if the diff is not equal, shift the pointer(low or high) towards right or left
//base case: once you reach two elements at the end, find the average and it returns missing number

import java.io.*;

class GFG {
    public static int search(int[] arr, int size){
        int low = 0;
        int high = size-1;
        int mid = 0;
        //base case:until you reach two elements at the end
        while((high - low) >=2){
            //finding mid pointer
            mid = low + (high-low)/2;
            //finding difference for low, mid and high
            int midIdxDiff = arr[mid] - mid;
            int lowIdxDiff = arr[low] - low;
            int highIdxDiff = arr[high] - high;
            //comparing differences and shifting low or high pointers
            if(midIdxDiff != lowIdxDiff){
                //shift high to left side
                high = mid;
            } else if(midIdxDiff != highIdxDiff){
                //shift low to higher side
                low = mid;
            }
        }
        //returning the average of two elements where the number is missing
        return (arr[low] + arr[high])/2;
    }

    public static void main(String[] args){
        int[] ar = {1,2,3,4,5,6,8};
        int size = ar.length;
        System.out.println("The missing number "+search(ar, size));
    }
}