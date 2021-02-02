import java.io.*;

class GFG {
    public static int searchMisssing(int arr[], int size){
        int low = 0;
		int high = size - 1;
		int mid = 0;
		
		while(high - low >=2){
		    mid = low + (high - low)/2;
		    
		    int lowIndexDiff = arr[low] - low;
		    int midIndexDiff = arr[mid] - mid;
		    int highIndexDiff = arr[high] - high;
		    
		    if(midIndexDiff != lowIndexDiff){
		        high = mid;
		    }
		    else if(midIndexDiff != highIndexDiff){
		        low = mid;
		    }
		}
		return (arr[low] + arr[high])/2;
		    
    }
	public static void main (String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6, 8, 9};
		int size = arr.length;
		System.out.println("Missing number: " + 
		                            searchMisssing(arr,size));
	}
}