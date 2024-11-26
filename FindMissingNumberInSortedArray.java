// Time Complexity : O(log n) where n is the length of given array
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/*
Question: https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/
Input : arr[] = [1, 2, 3, 4, 6, 7, 8]
Output : 5

Input : arr[] = [1, 2, 3, 4, 5, 6, 8, 9]
Output : 7
 */
class FindMissingNumberInSortedArray {
    public int search(int arr[] , int size){
        //null check
        if(arr == null || arr.length == 0)
            return 0;

        int low =0;
        int high = size -1;
        int mid = 0;

        while(high - low >=2){
            mid = low + (high -low )/2;
            int midIdxDiff = arr[mid] - mid;
            int lowIdxDiff = arr[low] - low;
            int highIdxDiff = arr[high] - high;

            if(midIdxDiff != lowIdxDiff){
                high = mid;
            }
            else low = mid;
        }
        return (arr[low] + arr[high])/2;
    }
    public static void main(String args[]){
        System.out.println("test");
    }
}
