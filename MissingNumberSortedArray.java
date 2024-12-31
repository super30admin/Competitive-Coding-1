//Time COmplexity: O(logn)
//space complexity: O(1)

package Interview;

public class MissingNumberSortedArray {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,6};
		
		System.out.println(findMissingElement(arr));
	}
	public static int findMissingElement(int[] arr) {
		if(arr.length == 0 || arr == null) {
			return -1;
		}
		int low = 0;
		int high = arr.length -1;
		while(high -low >= 2) {
			int mid = low + (high-low)/2;
			int lowIdxDiff = arr[low]-low;
			int midIndxDiff = arr[mid]- mid;
			if(lowIdxDiff != midIndxDiff) {
				high = mid;
			}else {
				low = mid;
			}
		}
		
		return ((arr[low]+ arr[high])/2);
	}

}

