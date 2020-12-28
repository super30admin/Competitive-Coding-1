Competitive Coding Question 1


package CompetitiveCoding1;

public class MissingElementSortedArray {
	private static int bsearch(int[] a) {
		int l = 0;
		int h = a.length-1;
		while(l+1 < h) {
			int mid = l + (h - l) / 2;
			
			//if(mid+1 == a[mid] && mid == a[mid-1]) {
			if(mid != a[mid] - 1) {
				h = mid;
			}
			else {
				l = mid;
			}
		}
		return a[l]+1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int[]{1,3,4,5,6,7};
		int res = bsearch(a);
		System.out.println(res);
	}
}