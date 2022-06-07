//Find the Missing Number in a sorted array


import java.io.*;
 
class Missingarray {
    static int search(int ar[], int size)
    {
        
        int low =0;
        int high =size -1;
        int mid =0;

        while(high-low>=2){
            mid = low + (high-low)/2;
            int midIndexDiff = ar[mid]-mid;
            int lowIndexDiff = ar[low]-low;
            int highIndexDiff = ar[high]-high;
            if(midIndexDiff!=lowIndexDiff){
                high = mid;
            }else if (midIndexDiff!=highIndexDiff){
                low = mid;
            }

        }
        return (ar[low]+ar[high])/2;

    }
 
    // Driver Code
    public static void main(String[] args)
    {
        int ar[] = { 1, 2, 3, 4, 5, 6, 8 };
        int size = ar.length;
        System.out.println("Missing number: "
                           + search(ar, size));
    }
}
 
//Time Complexity: O(log(N)), where N is the length of given array
//Auxiliary Space: O(1)