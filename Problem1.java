package competitive;

public class Problem1 {
	public static int findmissing(int[] nums,int n) {
		if(nums.length==0 || nums==null)
			return 0;
		
		int l =0;
		int h=nums.length-1;
		if(nums[0]!=1) {
			return 1;
		}
		if(nums[h]!=n)
			return n;
		
		while(l<h) {
			int mid= l+(h-l)/2;
			if(l==mid) 
			{
				return nums[mid]+1;
			}
			if(nums[mid]-nums[l]==mid-l) {
				l=mid;
			}
			else {
			h=mid;	
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] nums= new int[] {1,2,3,4,5,7};
		int n=7;
		int res= findmissing(nums,n);
		System.out.println("res:  "+res);
	}
}
