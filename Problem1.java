// Time Complexity : O(logn)
// Space Complexity : O(1)

import java.io.*;

class GFG {
    public static int binSearch(int arr[], int size){
        int low = 0;
        int high = size - 1;
        int mid = 0;
        while(high - low >= 2){
            mid = low + (high - low) / 2;
            
            int midIdxDiff = arr[mid] - mid;
            int lowIdxDiff = arr[low] - low;
            int highIdxDiff = arr[high] - high;
            
            if(midIdxDiff != lowIdxDiff){
                high = mid;
            } else if(midIdxDiff != highIdxDiff){
                low = mid;
            }
        }
        return (arr[low] + arr[high])/2;
    }
	public static void main (String[] args) {
		int[] arr = {1,2,3,4,6,7,8};
		int size = arr.length;
		System.out.println("Missing number: " + binSearch(arr, size));
	}
}