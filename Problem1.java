//Find Missing Number in a sorted array
//We are taking the approach as the sorted array value would be arr[i]=i+1
//Time complexity would be O(logn) and space would be O(1)

public class Problem1 {
	//Search for 3 here
	public static int binarySearch(int arr[]) {
		int n= arr.length;
		int low=0;
		int high=n-1;
		while(low<=high) { //initiated binary search
			
			int mid= low +(high-low)/2;
			//right sorting
			if(arr[mid]==mid+1) {
				low=mid+1;
			}
            //left sorting
			else {
				high=mid-1;
			}
		}
        //When the loop ends, low points to the index where the mismatch starts.
		return low+1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,4,5,6};
		int result = binarySearch(arr);
		System.out.print(result);
	}
}
