
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
	    int a[]={1,2,4,5,6,7,8};
	    fun(a);
		
	}
}

//time: O(logn)
//space : O(1)
//ran successfully
//Que : I didnt understand edge cases will you please explain me ? what if 1 or the last number missing. I understand if there is continuous num so it will return 1 for sure. but how about last element
