/ A binary search based program  
// to find the only missing number
// in a sorted array of distinct  
// elements within limited range.
import java.io.*;
 
class MissingNumberFromSortedArray  
{
static int search(int ar[],  
                  int size)
{
    int low =0;
    int high = ar.length - 1;
    int mid = 0;
   
    while(high - low > 1 ){
        mid = low + (high -low)/2;
       
        if(ar[high] - high != ar[mid] - mid){
           low = mid + 1;
        }
        if(ar[low] - low != ar[mid] - mid){
           high = mid;
        }
    }
    return  ar[mid] + 1;
}
 
// Driver Code
public static void main (String[] args)  
{
    int ar[] = { 1, 2, 3,4, 5, 6, 8 };
    int size = ar.length;
    System.out.println("Missing number: " +
                        search(ar, size));
}
}
 
/*
Time complexity O (logn) Space complexity O(1)
*/