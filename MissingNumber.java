public class MissingNumber{
	
	public int findMissingNumber(int[] arr) {
		int start=0;
		int end=arr.length-1;
		
		while((end-start)>1) {
			int mid=start+(end-start)/2;
			
			if(arr[mid]-mid==arr[start]-start) {
				start=mid;
			}else {
				end=mid;
			}
		}
		return arr[start]+1;
	}
	public void main(String[] args) {
		int[] arr= {1,2,3,5,6};
		System.out.print(findMissingNumber(arr));
	}
}
