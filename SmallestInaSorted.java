
public class SmallestInaSorted {
public static int binsearch(int [] x) {
	int low=0;
	int high=x.length-1;
	while(low<=high) {
		int middle=low+(high-low)/2;
		/*For detecting element*/
		if(middle!=0&&((x[middle]!=(x[0]+middle))&&(x[middle-1]==(x[0]+middle-1)))) {
			return x[0]+middle;
		}
		if(middle!=x.length-1&&(x[middle]==(x[0]+middle))&&(x[middle+1]!=(x[0]+middle+1))) {
			return x[0]+middle+1;
		}
		if((x[middle]-middle)==(x[low]-low)) {
			low=middle+1;
		}
		else {
			high=middle-1;
		}
	}
	return -1;
}
public static void main(String[] args) {
	int[] arr= new int[]{1,2,3,4,5,7};
	System.out.println(binsearch(arr));
}
}
