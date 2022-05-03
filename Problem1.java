
// Time Complexity :O(log n) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
public class Problem1 {
	private static int findElement(int[] a){
		if(a.length==0){
			return -1;
		}
		int s=0;
		int e=a.length-1;
		while(s<=e){
			int mid=s+(e-s)/2;
			if(a[mid]==mid+1){
				s=mid+1;
			}
			else{
				e=mid-1;
			}
		}
		return s+1;
	}
	private static int findElementm(int[] a){
		if(a.length==0){
			return -1;
		}
		int s=0;
		int e=a.length-1;
		while(s<=e){
			int m=s+(e-s)/2;
			if(s==e)
				return a[m]-1;

			if(a[m]==m+1)
				s=m+1;
			else if(a[m]>m+1)
				e=m;
			else
				s=m;
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] a1=new int[]{1,2,3,4,5,6,8};
		int[] a2=new int[]{1,3,4,5,6,7,8};
		int[] a3=new int[]{1,2,4,5,6,7};
		System.out.println("Missing no in a1"+" "+findElementm(a1));
		System.out.println("Missing no in a2"+" "+findElementm(a2));
		System.out.println("Missing no in a3"+" "+findElementm(a3));
	}
}
