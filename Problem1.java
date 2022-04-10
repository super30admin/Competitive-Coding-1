/*package whatever //do not write package name here */

import java.io.*;

class Problem1 {

    //Time Complexity = O(logn)
    //Space Complexity = o(1)
    //Did it successfully run on leetcode = Yes
    //Any problems faced during coding = No
    //In short describe your approach: I am taking the mid of high and low and then substracting if the 1st element of the array
    //minus the low and and the middle element of the array minus the mid. If they are not equal then the missing value is
    //supposed to lie on the left side of the array, hence pointing high to mid-1; else the missing no. lies in the 2nd
    //half of the array

    public static void main (String[] args) {
        int[] arr = {1,2,3,4,6};
        System.out.println("Missing no is=" + missing(arr));
    }
    static int missing(int [] arr){
        int low = 0;
        int high = arr.length - 1;
        while((high-low)>1){
            int mid = low + (high-low) / 2;
            if(arr[low] - low != arr[mid] - mid){
                high = mid - 1;
            }
            else if(arr[mid] - mid != arr[high]-high){
                low = mid + 1;
            }
        }
        return (arr[low]+1);
    }
}
