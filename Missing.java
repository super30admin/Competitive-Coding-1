//time complexity:O(logn)
//space complexity: O(1)
public class Missing
{
    int findMissing(int arr[], int N) 
{ 
	int left = 0, right = N - 1; 
	while (left <= right) { 

		int mid = (left + right) / 2; 

		if (arr[mid] != mid + 1 && arr[mid - 1] == mid) 
		{
            return mid + 1;          
        }
	
		if (arr[mid] == mid + 1) 
			left = mid + 1; 

		else
			right = mid - 1; 
	} 
    return -1; 
} 

// Driver code 
public static void main(String args[]) 
{ 
	int arr[] = {1,3,4,5,6,7,8}; 
	int size = arr.length;
	Missing fM= new Missing();
	System.out.println(fM.findMissing(arr, size));
} 
}