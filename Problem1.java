/**
 * https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/
 * 
 * Given a list of n-1 integers and these integers are in the range of 1 to n. 
 * There are no duplicates in list. 
 * One of the integers is missing in the list. 
 * Write an efficient code to find the missing integer. 

    Examples:

    Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
    Output : 4

    Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]
    Output : 3
 * 
 */

/**
 * time: O(n)
 * space: O(1)
 * 
 * approach:
 * Basic approach as the array is from 1 to n and consecutive
 * We can say that 
 *      input[i] = i+1
 * 
 * For example:
 * [1, 2, 3, 5, 6, 7, 8]
 * 
 *      input[i] = i+1
 *            1  = 0+1
 *            2  = 1+1
 *            3  = 2+1
 *            5  = 3+1 ==> this is not true, thus we are missing the actual element 4 here
 * 
 * Thus, return input[i]-1 when this above condition occurs 
 *  
 */
class Problem15{
    
    public int findMissing(int[] input){
        for (int i = 0; i<input.length; i++) {
            if (input[i]!=i+1) {
                return input[i]-1;  
            } 
        }
        return 0;
    }   
}

/**
 * Using binary search
 * 
 * time: O(nlogn)
 * space: O(1)
 * 
 * Approach:
 * Use the offset
 * 
 * 1. If the no.s are sorted and consecutive then the offset w.r.t index will be 1
 * 2. If the mid offset w.r.t index is not equal to the L offset
 *      move to left
 * 3. If the mid offset w.r.t index is not equal to the H offset
 *      move to right
 * 
 * Example:
 * 
 *  0   1   2   3   4   5   6   ==> index
 *  1   2   3   5   6   7   8   ==> numbers
 *  |           |           |
 *  L           M           H
 * 
 *  1-0 != 5-3
 *    1 != 2   -- true
 *    H = M    -- move left as offset is misaligned
 */
class Problem15BinarySearch{
    
    public int findMissing(int[] input){
        
        if(input[0] != 1) return 1;
        if((input[input.length-1]) != (input.length + 1)){
            return input.length+1;
        }

        int low = 0;
        int high = input.length-1;
        
        while((high - low) > 1){
            int mid = low + (high-low)/2;

            if (input[low] - low != input[mid] - mid) {
                high = mid;
            }
            if (input[high] - high != input[mid] - mid) {
                low = mid;
            }
        }
        return input[low] + 1;
    }   
}

public class Problem1{
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 7, 8};
        int result = new Problem15().findMissing(arr);
        int result2 = new Problem15BinarySearch().findMissing(arr);
        
        System.out.println(result);
        System.out.println(result2);
    }
}
