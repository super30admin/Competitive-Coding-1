/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    
    public static int search(int arr[], int size){

    int low = 0;
    int high = size -1;
    int mid = 0;
    
    while(high - low >= 2){
        mid = low + (high - low) /2;
        int midIdxDiff = arr[mid] - mid;
        int lowIdxDiff = arr[low] - low;
        
        if(midIdxDiff != lowIdxDiff ){
            high = mid;
        }else{
            low = mid;
        }
    }

     return (arr[low]+arr[high])/2;

}
    
    
    
	public static void main (String[] args) {
	    
	    int arr[] = {1,2,3,4,5,6,7,9};
	    int size = arr.length;
		System.out.println("Missing No!" + search(arr,size));
	}
}