//to find the missing number:
// Time Complexity : O(logN)
// Space Complexity : O(1)
// Code Run: Yes

import java.io.*;
import java.lang.*;

class MissingNumber {

    public static int fun(int a[])
    {
        int low=0;
        int high=a.length-1;
        int mid=0;
        //num-index
        while(high-low>=2){
            mid = low + (high-low)/2;
            int midDifference =a[mid]-mid;
            int leftDifference=a[low]-low;
            if(midDifference!=leftDifference){
                high=mid;
            }
            else{
                low=mid;
            }
        }
        System.out.println((a[low]+a[high])/2);
        return (a[low]+a[high])/2;
    }
	public static void main (String[] args) {
	    int a[]={3,4,5,7,8,9,10};
	    fun(a);

	}
}
