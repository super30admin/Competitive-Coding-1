
public class FindRemaining {
	
	public static int find(int arr[]) {
		int length = arr.length;
		int total = (length+1)*(length+2)/2;
		for(int i=0;i<length;i++) {
			total-=arr[i];
		}
		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 int[]arr= {1,2,3,5,6,7,8};
	 System.out.println(find(arr));

	}

}