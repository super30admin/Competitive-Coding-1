//https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/

// Given a list of n-1 integers and these integers are in the range of 1 to n. 
// There are no duplicates in list. One of the integers is missing in the list. 
// Write an efficient code to find the missing integer. 
//TimeComplexity: O(log n) where n is the size of the input Array
//Space Complexity: O(1) since we arenn't using any extra datastructures that grows in size with input apart from the 3 int variables

public class Problem1 {

    int[] inputArray;

    public int findMissingElementInASortedArray(int[] inputArray) {
        this.inputArray = inputArray;
        int low = 0;
        int high = inputArray.length - 1;
        int mid = 0;
        // for (int i = 0; i < inputArray.length; i++) {
        // if (inputArray[i] != (i + 1))
        // return ++i;
        // }

        while (low < high) {
            mid = low + (high - low) / 2;
            if (inputArray[mid] == mid + 1) {
                low = mid + 1;
            } else
                high = mid - 1;
        }

        if (low + 1 < inputArray.length)
            return low + 1;
        return -1;

    }

    public static void main(String[] args) {
        Problem1 p1 = new Problem1();
        int[] arr = new int[] { 1, 2, 3, 4, 6, 7, 8 };
        System.out.println(p1.findMissingElementInASortedArray(arr));
        arr = new int[] { 1, 2, 3, 4, 5, 6, 8, 9 };
        System.out.println(p1.findMissingElementInASortedArray(arr));
        System.out.println(p1.findMissingElementInASortedArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
    }
}
