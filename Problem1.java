/* S30 Big N Problem #14 {Easy}
Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.

Examples:

Input : arr[] = [1, 2, 3, 5, 6, 7, 8]



Output : 4





Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]



Output : 3


*/
// Time Complexity : O(log n)
// Space Complexity : O(1)

// Your code here along with comments explaining your approach

//Each element is one greater than its index till there is an element that is skipped(missing element). 
//That is each element is equal to its next index till the point of missing element.
class Problem1{
	/*public int findMissing(int[] arr){
		int low = 0;
		int high = arr.length-1;
		while(low<=high){
			int mid = low + (high-low)/2;
			//Find mid, check if arr[mid] it is equal to its next index(mid+1). If it is not equal, then we may have the number immediately after missing number. 
			//So we also check if the previous number(arr[mid-1]) is equal to index mid. If it is equal then the number lies between arr[mid-1] and arr[mid] and would be equal to mid+1. So return mid+1.
			if(arr[mid]!=mid+1 && arr[mid-1]==mid){
				return mid+1;
			}else if(arr[mid]!=mid+1){ //if only arr[mid} is not equal to its next index mid+1, then we know that the missing number lies towards the left. So reassign high to mid-1 and continue the search.
				high = mid-1;
			}else{ //if arr[mid] is equal to the next index, then all is fine upto mid, so the missing number must be towards the right of mid. So reassign low to mid+1 and continue the search.
				low = mid+1;
			}
		}
		return -1; //returning -1, if there is no missing element found.
	}*/

	public int findMissing(int[] arr){
		int low = 0;
		int high = arr.length -1;
		//missing element will be the mid of the two elements
		while(high - low >= 2){
			int mid = low + (high-low)/2;
			int midIdxDiff = arr[mid] - mid;
			int lowIdxDiff = arr[low] - low;
			//if the element and index differences of mid and low are not equal, it means the missing element lies between low and mid.
			if(midIdxDiff!= lowIdxDiff ){
				high = mid;
			}else{  // else it lies between high and mid
				low = mid;
			}
		}
		//once we get to two elements, the missing element is the mid of the two elements.
		return ((arr[low] + arr[high])/2);
	}
}

class Main{
	public static void main(String[] args){
		Problem1 p1 = new Problem1();
		int[] arr1 = {1, 2, 3, 5, 6, 7, 8};
		System.out.println(p1.findMissing(arr1));
		int[] arr2 ={1, 2, 4, 5, 6, 7, 8, 9};
		System.out.println(p1.findMissing(arr2));

	}
}