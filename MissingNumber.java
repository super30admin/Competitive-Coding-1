// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : no


/**
 * 1. Apply binary search and check mid+1,mid-1 to find missing number.
 * 2. mid-left should give length of left side array and arr[mid]-arr[left] should give length of left array.
 * 3. if both left side length are not equal check left side array other wise right side array.
 */
class MissingNumber {
    
    public static int binarySearch(int[] arr, int low,int high) {
		while(low<high) {
			int mid =low +(high-low)/2;
			
			if(mid !=low && arr[mid]-arr[mid-1]>1) {
				    return arr[mid]-1;
			}
			if(mid !=high && arr[mid+1]-arr[mid]>1) {
    				return arr[mid]+1;
			}
			
			int leftDiff = arr[mid]-arr[low];
			int actualLen = mid-low;
			
			if(leftDiff >actualLen) {
				 high= mid -1;
			}else {
				low = mid+1;
			}
			
		}
		return -1;
		
	}
    public static void main(String[] args) {
    	
    	int[] arr= new int[] {2,3,4,6,7};
    	System.out.println( binarySearch(arr,0,arr.length-1));
    }
}

