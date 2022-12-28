/*package whatever //do not write package name here */

class Problem1 {
	public static void main (String[] args) {
		int[] arr = {2,3,4,6,7,8};
		int num = findMissingNum(arr);
		System.out.println(num);
	}
	
	static int findMissingNum(int[] arr){
	    int low = 0;
	    int high = arr.length-1;
	    while (high - low >= 2){
	        int mid = low + (high-low)/2;
	        if (arr[mid]-mid == arr[low]-low) {
	            low = mid ;
	        } else {
	            high = mid ;
	        } 
	    }
	    return (arr[low] + arr[high])/2;
	}
}