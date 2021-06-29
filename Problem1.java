public static int missingElement(int[] arr) {
		if(arr == null || arr.length ==0)
			return -1;
		int low = 0,high = arr.length-1;
		while(low<=high) {
			int mid = low+(high-low)/2;
			//if mid is at crct place
			if(arr[mid] == mid+1) {
				low = mid+1;
			}else {
				high = mid;
			}
			if(low == high) {
				if(arr[low] == low+1)
					return low+2;
				else
					return low+1;
			}
			
		}
		return -1;
	}
	
	
	public static void main(String args[]) {
		int arr[] = {1,2,3};
		System.out.println(missingElement(arr));
	}