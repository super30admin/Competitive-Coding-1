import java.io.*;

class GFG {
	public static void main (String[] args) {
		int ar[] = { 1, 2, 3, 4, 5, 6, 8, 9 }; 
        int size = ar.length; 
        System.out.println("Missing number: " + missing(ar));
	}
	
	public static int missing(int[] array){
        int low = 0, high = array.length -1;
        
        while (low <= high){
	        int mid = low + (high-low)/2;
	        // no need to check for base condition for 2 reasons: 1. it gets very messy to code base condition             here. 2. we will handle it in the end by finding the index for the correct element 
	        if (array[mid] == mid+1){
	            low = mid + 1;
	        }
	        else{
	            high = mid - 1;
	        }
        }
        // if we are out of the loop that means whatever is on low index is the one with the right number
        // the expected number after the right number would be the missing number
        return low + 1;
	}
}
	       
