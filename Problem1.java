//Find the Missing Number in a sorted array

/*Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.

        Examples:
        Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
        Output : 4

        Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]
        Output : 3
*/

//TimeComplexity: O(logN)
//SpaceComplexity: O(1)

import java.io.*;

class Problem1 {
    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int missingElement =  SearchElement(arr);
        System.out.println("missingElement : " + missingElement);
    }

    public static int SearchElement(int[] arr){
        if(arr==null || arr.length==0) return 1;

        int low = 0, high = arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(mid+1 != arr[mid]){
                high = mid-1;
            } else {
                low=mid+1;
            }
        }
        return low+1;

    }

}


