//Find Missing Number in a Sorted Array
//Time Complexity : O(logn)
//Space Complexity : O(1)
// Code run successfully.
public class Problem1{
	
	public int missingNumber(int[] arr) {
		
		if(arr.length == 0|| arr.length == 1)
			return -1;
		
		int l = 0;
		int n = arr.length;
		int h = n-1;
		int mid;
		int ldiff, mdiff, hdiff;
		
		while(h >= l +2) {
			
			mid = l + (h-l)/2;
			
			ldiff = arr[l] - l;
			mdiff = arr[mid] - mid;
			hdiff = arr[h] - h;
			
			if(mdiff != ldiff) 
				h = mid;
			else if(hdiff != ldiff)
				l = mid;
		}
		
		return (arr[l] + arr[h])/2;	
	}
	
	public static void main(String[] args) {
		Problem1 ob = new Problem1();
		int[] arr = new int[] {6,8};
		int m = ob.missingNumber(arr);
		System.out.println(m);
	}
}
