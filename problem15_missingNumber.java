package CompetitiveCoding;

import java.util.HashSet;

public class problem15_missingNumber {

    /*
    Using HashSet ---->
        Time Complexity : O(n)
        Space Complexity: O(n) I guess, I am not sure about this tho as
                               I am checking if the set contains the missing value or not.
     */
    private static int missingElementHashSet(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int a: arr) {
            set.add(a);
        }
        int finalVal = arr.length + 1;

        for(int i = 0 ; i < finalVal ; i++) {
            if(!set.contains(i))
                return i;
        }
        return -1;
    }

    /*
    Using Binary Search Technique ----> // I AM UNABLE TO SOLVE THIS !!
                                        // Took the help form the article finally.
                                            But need to understand this again.
                                 https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/
        Time Complexity : O(log n)
        Space Complexity: O(1)
     */

    private static int missingElementBinarySearch(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

//        while(low <= high) {
        while((high - low) > 1) {

            mid = low + (high - low) / 2; // to avoid Integer Overflow

            if((arr[low] - low) != (arr[mid] - mid))
                high = mid - 1;
            else if((arr[mid] - mid) != (arr[high] - high))
                low = mid + 1;
            else break;
        }
//        return -1;
        return arr[low] + 1;
    }

    /*
    Using Mathematical Computation ---->
        Time Complexity : O(n)
        Space Complexity: O(1)
     */
    private static int missingElementMathematicalComputation(int arr[]) {
        int maxSum = (arr.length)*(arr.length + 1) / 2;
        for(int a: arr) {
            maxSum -= a;
        }
        return maxSum;
    }


    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 4, 5, 6, 7, 8, 9};

        int missingVal = missingElementHashSet(arr);
        System.out.println("The missing element is (Using Hashset): " + missingVal);

        int missingVal1 = missingElementBinarySearch(arr);
        System.out.println("The missing element is (Using Binary Search): " + missingVal1);

        int missingVal2 = missingElementMathematicalComputation(arr);
        System.out.println("The missing element is (Using Maths): " + missingVal2);
    }
}