// Time Complexity : O(log N) where N is the number of elements in the Array
// Space Complexity : O(1)

class Solution{
	public static int getMinimum(int[] arr){
		int low = 0;
		int high = arr.length-1;
		while(high-low>2){
			int mid = low + (high-low)/2;
			int midIndex = arr[mid] - mid;
			int highIndex = arr[high] - high;
			int lowIndex = arr[low] - low;

			//Left Sorted
			if(lowIndex == midIndex) return start = mid;
			//Right Sorted
			if(highIndex == midIndex) return end = mid;
		}

		return (arr[high]-arr[low])/2;
	}

	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,8,9};
		System.out.println(getMinimum(arr));
	}
}