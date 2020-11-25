/*
Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, 
One of the integers is missing in the list. Write a code to find the missing integer.

Examples:

Input : arr[] = [1, 2, 3, 5, 6, 7, 8
Output : 4

Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]
Output : 3

Solution:
Traverse array once and check if the difference betweeen a[i] and a[i+1] is 1. 
If the difference is 2 then missing number would be a[i+1]-1.

Assumptions:
Assuming that the integers are in sorted order and there is only 1 missing integer
Time Complexity: O(N)
Space Complexity: O(1)
If the numbers are always starting from 1..n then we can use binary search approach which will be O(log(N))
*/
public class Problem1 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5, 6, 7, 8};
        int missingNum = findMissingNum(a);
        System.out.println("missing number is "+missingNum);
    }
    static int findMissingNum(int[] a){
        for(int i=0; i < (a.length-1); i++) {
            if(a[i+1] - a[i] != 1)
                return a[i+1]-1;
        }
        return -1;
    }
}