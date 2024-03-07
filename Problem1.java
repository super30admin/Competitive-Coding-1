// "static void main" must be defined in a public class.// Find Missing Number in a sorted array
// Input : arr[] = [1, 2, 3, 5, 6, 7, 8]Output : 4//Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]Output : 3
//Time Complexity O(log n)
//Space complexity O(1)
import java.util.*;

public class Problem1 { 
public static void main(String[] args) { 
    int[] arr = {1, 2, 3, 5, 6, 7, 8}; 
    System.out.println(Arrays.toString(arr)); 
    Problem1 p = new Problem1();
    System.out.println(p.findMissing(arr)); 
} 
public static int findMissing(int[] arr){ 
    int low = 0; 
    int high = arr.length -1; 
    int mid = 0; 

    while(high - low >= 2){ //means there is a number missing between high and low
        mid = low + (high - low)/2; 
        int lowIdxDiff = arr[low] - low; 
        int highIdxDiff = arr[high] - high; 
        int midIdxDiff = arr[mid] - mid; //no missing element 
        if(midIdxDiff != lowIdxDiff){ 
            high = mid; 
        }else if(midIdxDiff != highIdxDiff){ 
            low = mid; 
        }
            } 
        return (arr[low] + arr[high])/2;
     }
    }