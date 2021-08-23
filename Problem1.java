// Time Complexity : O(log n)
// Space Complexity :o(1)
// Any problem you faced while coding this : No


public class MissingElement {
	
 public static int	SearchMissing (int arr[])
 {
	 int l=0;
	 int r=arr.length;
	 while(r-l>1)
	 {
		 int mid = l+(r-l)/2;
		 if(arr[l]-l!=arr[mid]-mid)
		 {
			 r=mid;
		 }
		 else {
			 l=mid;
		 }
		 
	 }
	 return (arr[l]+arr[r])/2; 
 }

 public static void main (String args[])
 {
	 int[] nums = new int[] {4,5,6,7,8,10};
	 System.out.println("missing element is "+ SearchMissing(nums));
 }
 
}
