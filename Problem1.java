
// Find missing number in an array 

public class MissingNumMock1 {

	public static void main(String args[]) {

		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 10 };
		int value = binarySearch(arr);
		System.out.println(value);

	}

	static int binarySearch(int arr[]) {
		int low = 0;
		int high = arr.length - 1;
    while(high - low > 1){
         int mid = low + (high-low)/2;
         if(arr[mid] > mid+1){
           high = mid;
           else
             low = mid;
         }
    }
    return arr[low] +1;
}

  // Time complexity O(log n )
  // Space Complexity O (1)
