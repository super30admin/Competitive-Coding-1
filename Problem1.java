//Problem 1 : Find the missing element
// TC = O(log N), SC = O(1)
// Approach: We use binary search to locate the index where the element breaks the expected sequence. 
// If arr[mid] == mid + 1, then left half is fine, so search right. 
// Else, search the left half. Final position of `left` gives the missing number.
class MissingElement{
    public static int missingElement(int[] arr){
        int left = 0, right = arr.length-1;//first and last index of the array

        while(left<=right){
            int mid = left + (right-left)/2; //Stack Overflow

            if(arr[mid] == mid+1){ 
                left = mid+1; // element present on the right half
            }

            else{
                right = mid-1; // element is present on the left half
            }
        }

        return left + 1;
    }
   
}

