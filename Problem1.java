// Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. 
// Write a code to find the missing integer.

// Time Complexity: O(n) - Traversing all numbers in the array + 1
// Space Complexity: O(n) - Holding an array of input array length to store data
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MissingInteger {

    int getMissingInteger(int[] n) {
        // Creating a boolean array of size n.length+1 to store which numbers in range 1 to n exists
        boolean[] temp = new boolean[n.length+1];
        for(int i=0; i<n.length; i++) {
            temp[n[i]-1] = true;
        }

        // Checking the boolean array to find missing number 
        for(int i=0; i<temp.length; i++) {
            if(temp[i] == false) {
                return i+1;
            }
        }

        // Return the last number + 1 if all numbers are in sequence in the given array.
        return n.length+1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        MissingInteger m = new MissingInteger();
        int missingNumber = m.getMissingInteger(arr);
        System.out.println("Missing number in array is " + missingNumber);
    }
}
