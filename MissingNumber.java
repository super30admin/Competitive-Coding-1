
/*PROBLEM:-
Missing in a Sorted Array of Natural Numbers
Given a sorted array arr[] of n-1 integers, these integers are in the range of 1 to n. There are no duplicates in the array. One of the integers is missing in the array. Write an efficient code to find the missing integer. 
Input : arr[] = [1, 2, 3, 4, 6, 7, 8]
Output : 5
Explanation: The missing integer in the above array is 5 

Input : arr[] = [1, 2, 3, 4, 5, 6, 8, 9]
Output : 7
Explanation: The missing integer in the above array is 7 */

/*Time Complexity:o(logn)->n is length of array
Space Complexity: O(1)
Approach:The array contains numbers from 1 to n+1 with one number missing. Since the array is sorted, we can use binary search to efficiently find the missing number. In a perfect sequence, the difference between the value and its index should be constant.We compare differences at low, mid, and high to determine where the missing number lies.*/
class MissingNumber {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.println(missingNumber(arr));
    }

    public static int missingNumber(int[] arr) {
        int size = arr.length;// Size of the array
        if (arr[0] != 1)// checking if first element(which is 1 always) is present, if not it is the
                        // missing number.
        {
            return 1;
        }
        if (arr[size - 1] != size + 1)// checking if last element(which is size+1 always) is present, if not it is the
        // missing number.
        {
            return size + 1;
        }
        // implementing binary search
        int low = 0;// lower bound
        int high = size - 1;// upper bound
        // Continue while there's more than one element between low and high
        while ((high - low) > 1) {
            int mid = low + (high - low) / 2;// prevents Integer Overflow
            // Check if the missing number lies between low and mid
            // Normally, arr[index] - index should be same throughout
            if ((arr[low] - low) != (arr[mid] - mid)) {
                high = mid;// Narrow search to left half
            } else if ((arr[high] - high) != (arr[mid] - mid)) {// Otherwise, the missing number lies between mid and
                                                                // high
                low = mid;// Narrow search to right half
            }
        }
        // The missing number is between arr[low] and arr[high]
        // Since only one number is missing, it is arr[low] + 1
        return (arr[low] + 1);
    }
}