import java.io.*;

class GFG {

    static int findMissingElement(int[] arr){
        int low = 0;
        int high = arr.length -1;
        int mid = 0;
        while(high-low >1){
            mid = low +(high-low)/2;
            if(arr[mid]-mid >1 ){
                high = mid;
            }
            else {
                low = mid;
            }

        }
        return arr[low]+1;

    }
	public static void main (String[] args) {
	    int [] arr = {1,2,3,4,5,6,7,9};
	    int result = findMissingElement(arr);
		System.out.println("Missing Element:" +result);
	}
}
