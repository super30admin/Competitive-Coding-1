
//Problem 15 : Missing Numbr in a sorted array ranging from 1 to n
//TC : O(log(n)), n is number of elements in a given array
//SC : O(1)



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