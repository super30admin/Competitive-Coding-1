/**
Problem: find missing number in sorted array of size (n-1) with elements from 1 - n
https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/
*/
public class Main {
	public static int findMissingNumber(int arr[], int n) {
		
        int low = 0, high = arr.length - 1;
        int mid = 0;
        
        // Missing first number
        if (arr[low] - low == 2) {
            System.out.println("First number is missing");
            return 1;
        }
        
        // Either no number is missing or the last number is missing
        if (arr[low] - low == 1 && high - low == arr[high] - arr[low]) {
            // No number is missing
            if (arr.length == n) {
                System.out.println("No number is missing");
                return -1;
            } else { // last number missing
                System.out.println("Last number is missing");
                return n;
            }
        }
        
        // While there are at least 2 elements
        while (high - low >= 2)
        {
            mid = low + (high - low) / 2;
            if ((arr[low] - low) != (arr[mid] - mid))
                high = mid;
            else
                low = mid;
        }
        return (arr[low] + arr[high]) / 2;
	}

	public static void main(String args[]) {
		int arr[] = new int[] {2,3,4,5,6};
		System.out.println(findMissingNumber(arr, 6));
	}
}

