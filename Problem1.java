

public class week1_Interview1 {
	
	int binarySearch(int arr[]) 
    { 
        int l = 0, r = arr.length - 1; 
        int m = l + (r - l) / 2; 
        System.out.println(m);
        int left = m-1, right = m+1;
        if(arr[left]!=arr[m]-1) return arr[m]-1;
        if(arr[right]!=arr[m]+1) return arr[m]+1;
        while (l <= r) { 
        	if(left==0 && right==arr.length-1) {
        		return 0;
        	}
        	if(left!=0) {
            if(arr[left-1] == arr[left]-1) {
            	left = left - 1;
            }
            else {
            	return arr[left]-1;
            }
        	}
        	if(right<arr.length-1) {
            if(arr[right+1] == arr[right]+1) {
            	right = right + 1;
            }
            else {
            	return arr[right]+1;
            }
        	}
        } 
        return -1; 
    } 

	public static void main(String[] args) {
		week1_Interview1 missingNumbers = new week1_Interview1(); 
        int arr[] = { 1, 2, 3, 4, 5, 7, 8, 9, 10 }; 
        int result = missingNumbers.binarySearch(arr); 
        if(result ==-1) System.out.println("No missing element");
        else
        System.out.println("Missing element is "+ result);
	}

}
