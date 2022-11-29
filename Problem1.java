
public class MissingElement {

	public static int missingElement(int arr[]) {
		int low=0;
		int high = arr.length-1;
		int mid =0;
		while(high-low >1) {
			mid= low + (high-low)/2;
			int midDiff = arr[mid]-mid;
			int lowDiff = arr[low]-low;
			
			if(midDiff==lowDiff)
				low=mid;
			else
				high = mid;
			
		}
		return arr[low]+1;
	}
	public static void main(String args[]) {
		int arr[] = {5, 6,7, 9};
		System.out.println(missingElement(arr));
	}
}

//Solution 2
public class MissingElement {

	public static int missingElement(int arr[]) {
		int low=0;
		int high = arr.length-1;
		int mid =0;
		while(high-low >=2) {
			mid= low + (high-low)/2;
			int midDiff = arr[mid]-mid;
			int lowDiff = arr[low]-low;
			
			if(midDiff==lowDiff)
				low=mid;
			 {
				high = mid;
			}
		}
		return (arr[low]+arr[high])/2;
	}
	public static void main(String args[]) {
		int arr[] = {5, 7, 8, 9};
		System.out.println(missingElement(arr));
	}
}
