#timecomplexity -O(logn)
#space complecity -O(1)
  
  class GFG {
	public static void main (String[] args) {
		int[] arr = {2,3,4,5,6,7,9};
		int l =0 ;
		int h = arr.length - 1;
	    while(h-l>=2){
	        int m = l+(h-l)/2;
	        int lowDiff = arr[l] - l;
	        int midDiff = arr[m] - m;
	        if(lowDiff != midDiff){
	            h = m;
	        }else{
	            l = m;
	        }
	    }	
	    System.out.println((arr[l]+arr[h])/2);
	}
}
