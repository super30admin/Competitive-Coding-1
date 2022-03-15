#timecomplexity -O(logn)
#space complecity -O(1)

class GFG {
	public static void main (String[] args) {
		int[] arr = {1,2,3,5,6,7,8};
		int l =0 ;
		int h = arr.length - 1;
		int index=0;
		while(l<h){
		    int m = l+(h-l)/2;
		    
		    if(m+1 == arr[m]){
		        l=m+1;
		    }else{
		        if(m==arr[m-1]){
		            index = m;
		        }
		        h=m-1;
		    }
		}
		System.out.println(arr[l]-1);
	}
}
