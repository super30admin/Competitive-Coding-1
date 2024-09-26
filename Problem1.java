
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,5}; 
		
		int left = 0;
		int right = arr.length - 1;
		
        //loop through the array unitil the left pointer < right pointer
        // in each iteration, calculate the mid value
        //and check if elements adjacent to mid element are increment or decrement by 1
        // if so print the missing element and return
        //else if the number of elements on left side matches the value move left  to mid + 1
        //else move right to mid - 1
		while(left < right) {
			int mid = (right + left )/ 2;
			
			if(!(arr[mid-1] == (arr[mid] - 1) )) {
				System.out.println("This is the missing element :"+ (arr[mid]-1)); 
				return; 
			}else if(!(arr[mid + 1] == (arr[mid] + 1))) {
				System.out.println("This is the missing element: "+ (arr[mid] + 1));
				return;
			}else if(arr[mid] == mid + 1) {
				left = mid + 1;
				System.out.println("left :" + left);
			}else {
				right = mid - 1;
				System.out.println("right: "+ right);
			}

		}
		
		System.out.println("NO element is missing");
	}

}


//Time Complexity: O(log n)
//Space Complexity: O(1)