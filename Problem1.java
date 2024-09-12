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


// Alternate simpler approach
public class Main {
	static int search(int nums[], int size)
	{
        if (nums == null || nums.length == 0)
            return -1;
        
        int n = nums.length - 1;
        int low = 0, high = n;
        
        // The array is fully sorted and there are no missing elements
        if (nums[low] - low == nums[high] - high)
            return -1;
        
        while (high - low > 1) {
            int mid = low + (high - low) / 2;
            
            if (nums[low] - low != nums[mid] - mid) {
                high = mid;
            } else if (nums[high] - high != nums[low] - low) {
                low = mid;
            }
        }
        
        // If the numbers are sorted in descending order
        if (nums[0] > nums[n])
            return nums[low] - 1;
        else // If numbers are sorted in ascending order
            return nums[low] + 1;
	}

	// Driver Code
	public static void main(String[] args)
	{
		int ar[] = {8,7,6,4,3,2,1};
		int size = ar.length;
		System.out.println("Missing number: "
						+ search(ar, size));
	}
}

