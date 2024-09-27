//Time Complexity: O(log N) by Binary Search
//Space Complexity: O(1)

class MissingNumber {
    
    static int search(int[] arr, int size)
    {
        int l = 0;
        int r = size - 1;
        int mid = 0;
        
        while(l <= r)
        {
            mid = l + (r - l) / 2;
            
            if(arr[mid] != mid + 1 && arr[mid-1] == mid)
                return mid + 1;
                
            if(arr[mid] == (mid + 1))
            {
                l = mid + 1;
            }
            else
            {
                r = mid - 1;
            }
        }
        return -1;
    }
    
	public static void main (String[] args) {
		int arr[] = {1, 2, 4, 5, 6, 7, 8, 9}; 
        int size = arr.length; 
        System.out.println("Missing number: " + 
                        search(arr, size)); 
	}
}
