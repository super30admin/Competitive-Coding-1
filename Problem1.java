
//Problem: 
// Provide an array of n-1 integers in the range of 1 to n with no 
// duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer
// Input : arr[] = [1, 2, 3, 5, 6, 7, 8]

/**Since the element are in order, we can take advantage of Binary Search algo.
 * The target will lies in either halves at each iteration
 * we can compute middle index and check if the 
 * middle-prvious !=1  OR
 * next - middle !=-1 , these 2 conditions will give the missing number
 * else keep increasing start or decreasing end as per condition.
 
 */
//
// time Complexity :
// O(Log N) 

// Space Complexity :
// O(1) - updated same array and not used extra space.

// Did this code successfully run on Leetcode : YES.
// Any problem you faced while coding this : NO.

public class Problem1 {

    public static void main(String[] args) {

        int[] arr1 = new int[] { 4, 5 };

        System.out.println(missinNo(arr1));

    }

    static int missinNo(int[] arr) {

        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            //edge cases
            if (mid == arr.length - 1)     //last element
                return arr[mid - 1] + 1;
            else if (mid == 0)             // first element
                return arr[mid + 1] - 1;
            

            if (arr[mid] - arr[mid - 1] != 1)  // found target here between middle and previous
                return arr[mid] - 1;
            else if (arr[mid + 1] - arr[mid] != 1)  // found target here between middle and next 
                return arr[mid] + 1;
            
            //move start or end
            if (arr[mid] == mid + 1) 
                start = mid + 1;
             else 
                end = mid - 1;
            
        }

        return -1;
    }

}
