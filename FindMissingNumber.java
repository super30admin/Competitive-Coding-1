/*package whatever //do not write package name here */

//Time Complexity: O(log N) (Ps. can you please explain me how the Time complexity is O(Log N) as i am little confused about it now
//Space Complexity: O(1)
//Issues Faced: Initially syntactical errors and in Geeks IDE, search method was not declared and i forgot to do it and got error
//Did it run successfully on GeeksForGeeks: Yes

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
