//Missing Element problem- Competitive coding problem 
// Time Complexity : O(log n) because we divided the array into half and kept searching in it. In short we straight away reducing the half part of array
// Space Complexity : O(1) as we are not storing 
// Any problem you faced while coding this : no

/*Output
The missing number is:6

*/

public class missingElement {

	private static int missingElements(int[] arr, int arr_length) {
		//apply Binary Search on arr to find the missing element. 
		
		int low=0;
		int high=arr_length-1;
		
		//check difference between arr[mid] and it'd index i.e. mid and if it's equal to arr[low] and low then move towards right i.e. low = mid+1
		//if not then vise versa

		while(low<high) {
		    int mid=low+((high-low)/2);
//if missing element is at mid
			if((arr[mid] - mid) != (arr[mid-1]-(mid-1)))
			{
				int r=(arr[mid-1]+arr[mid])/2;
				return r;
			}
			else if((arr[mid] - mid) != (arr[mid+1]-(mid+1)))
			{
				int r=(arr[mid+1]+arr[mid])/2;
				return r;
			}

			if((arr[mid]-mid) == (arr[low]-low))
			{
				low=mid+1;
			}
			else //if((arr[mid]-mid) != (arr[low]-low))
			{
				high=mid-1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	int[] arr= {1,2,3,5,6,7};
		int[] arr= {1,2,3,4,5,7};
	//	int[] arr= {1,3,4,5,6,7};
	//	int[] arr= {2,3,4,5,6,7};
		
		int result=missingElements(arr, arr.length);
		System.out.println("The missing number is:" + result);
	}

	
}
