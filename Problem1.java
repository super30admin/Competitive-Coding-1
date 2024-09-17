/** Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.
Examples:
Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
Output : 4
*/

/**Approach
 * Step 1: Brute Force Approach - Iterate over the whole array and check if (index+1) and the arr[index] are equal. If not return index+1;
 * TC - O(n)
 * 
 * Step 2: Binary Search Approcah - take two pinters, high and low and find the middle of the array.
 * If the value at the mid and mid-1 are correct then shift the low pointer to mid+1 else high pointer becomes mid-1;
 * TC - O(log n) 
 */

class Problem1{
    public int missingNum(int[] arr){
        int low = 0;
        int high = arr.length -1;
        if(arr[0]!=1){
            return 1;
        }
        while(low<=high){
            int mid = low + (high - low)/2;
            if(arr[mid]!= mid+1 && arr[mid-1] == mi){
                return mid+1;
            }
            if(arr[mid] == mid+1){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}
