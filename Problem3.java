public class FindMissing {
	
	public static int find(int arr[]) {
		int start =0;
		int end = arr.length-1;
		int mid;
		while(start<end) {
			 mid = start + (end-start)/2;
				if(!(mid==arr.length-1 || arr[mid+1]-arr[mid]==1) && (arr[mid]-arr[mid-1]==1	|| mid==0)) {
					return arr[mid]+1;
				}
			 if(arr[mid]!=mid+1) {
				 end = mid-1;
			 }else {
				 start = mid+1;
			 }
			
		}
		return -1;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[]arr= {1,2,3,4,6,7,8};
		 System.out.println(find(arr));

	}

}