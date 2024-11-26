//Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.
//
//        Examples:
//
//        Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
//        Output : 4
//
//
//        Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]
//        Output : 3
//
//



// Soution 1
import java.io.*;

public class MissingElement
{
    static int search(int ar[],  int n)
    {
        int i, sumN, total;
        int sumA=0;
        sumN = ((n+1)*(n+2))/2;
        for(i=0;i<ar.length;i++){
            sumA += ar[i];
        }
        total = sumN - sumA;
        return total;
    }

    // Driver Code
    public static void main (String[] args)
    {
        int ar[] = { 1, 2, 3, 4, 5, 6, 7};
        int n = ar.length;
        System.out.println("Missing number: " +
                search(ar, n));
    }
}


//Solution 2
import java.io.*;

public class MissingElements
{
    static int search(int ar[],  int n)
    {
        int x1 = ar[0];
        int x2 = 1;

        /* For xor of all the elements
           in array */
        for (int i = 1; i < n; i++)
            x1 = x1 ^ ar[i];

        /* For xor of all the elements
           from 1 to n+1 */
        for (int i = 2; i <= n + 1; i++)
            x2 = x2 ^ i;

        return (x1 ^ x2);
    }

    // Driver Code
    public static void main (String[] args)
    {
        int ar[] = { 1, 2, 3, 4, 5, 6, 7};
        int n = ar.length;
        System.out.println("Missing number: " +
                search(ar, n));
    }
}


//Solution 3
// Time Complexity: O(log n)
// Space Complexity: O(1)
import java.io.*;

public class MissingEl
{
    static int search(int ar[],
                      int size)
    {
        int low= 0;
        int high = size-1;
        int mid = 0;

        while(high-low >= 2){

            mid= low + (high-low)/2;
            int midIndexDifference = ar[mid] - mid;
            int lowIndexDifference = ar[low] - low;
            int highIndexDifference = ar[high] - high;
            if(midIndexDifference!=lowIndexDifference){
                high = mid;
            }
            else if(midIndexDifference!=highIndexDifference){
                low= mid;
            }
        }

        return (ar[low]+ar[high])/2;

    }

    // Driver Code
    public static void main (String[] args)
    {
        int ar[] = { 1, 2, 3, 4, 5, 6, 8 };
        int size = ar.length;
        System.out.println("Missing number: " +
                search(ar, size));
    }
}
