/*
Provide an array of n-1 integers in the range of 1 to n with no duplicates in list,
One of the integers is missing in the list. Write a code to find the missing integer.
Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
Output : 4

Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]
Output : 3

 */


/*
Time Complexity = O(logN) //binary search
Space Complexity = O(1) //no extra space
 */

public class Problem1{
    public static int search(int[] arr, int size){
        int low = 0;
        int high = size -1;
        int mid = 0;
        while(high - low >= 2){
            mid = low + (high - low)/2;
            int midIdxDiff = arr[mid] - mid;
            int lowIdxDiff = arr[low] - low;
            int highIdxDiff = arr[high] - high;
            if(midIdxDiff != lowIdxDiff){
                high = mid;
            }else if(midIdxDiff != highIdxDiff){
                low = mid;
            }
        }

        return (arr[low] + arr[high])/2;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 7, 8};
        int size = arr.length;
        System.out.println(search(arr,size));

    }
}
