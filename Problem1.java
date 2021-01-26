//Problem 15 : Missing Numbr in a sorted array ranging from 1 to n
//TC : O(log(n)), n is number of elements in a given array
//SC : O(1)

/*Steps
 As the given array is sorted, binary search can be implmeneted. As 1st number will be 1 or some other which won't me missing, therefore its going to be the starting number.Initialise startNum with the arrays first element. If the difference between the mid and element at that mid is not equal to array's first element - 0, it means the missing number will be on the left side otherwise missing number will be on the right side.
 Finally just return the (element +1) at the end pointer. However, there could be a case when 1 is missing(if interviewer says that).Then initialize startNum with 1. Here end pointer is going to give -1, just return 1 if end pointer returns -1. 
*/

//Note: This problem can be solved using kth missing number also, but for kth missing number should start from 1 only. Below code is scallable only for 1st missing number but here start can be any number 

class Solution15
{
	public static void main(String[] args) {
		
       //assuming, first number will never be missing
		int arr[] = {1, 2, 3, 4, 6, 7, 8}; //op ->5
		//int arr[] = {1, 2, 3, 4, 5, 6, 8, 9};//op ->7
		//int arr[] = {2, 3, 4, 5, 6, 8, 9};//op ->1
		//int arr[] = {1,2, 3, 4, 5, 6, 7};//op ->8
        //int arr[] = {3,5,6,7,8}; //op ->4 
		
		int start = 0;
		int end   = arr.length-1;
		int startNum = arr[0];//assuming that first number is not missing
		while(start<=end){
		    int mid = start+(end-start)/2;
		    int midIdxDiff   = arr[mid]-mid;
		    int startIdxDiff = startNum-0;
		    
		    if(midIdxDiff!=startIdxDiff){//compare start index difference and the mid index difference, if they are not same means mising element is on left side
		        end = mid-1;
		    }else{
		        start = mid+1;
		    }
		}
		
		int res = end==-1 ? 1 : arr[end]+1;//required when first number can be missing
		
		System.out.println("Missing number is "+res);
	}
}

