import java.io.*;
import java.util.*;

// Time Complexity : O(LogN)
// Space Complexity : O(1)
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

// This is on sorted array  only
// -> While it runs in the loop till high -low>=2 otherwise if one or no element directly jumps to the return statement
// -> set low and high and calculate value at index 
// -> if lowIndex and midIndex are same, this means that there is no missing element and we need to search right side. so set low to mid
// -> else set high to mid 

public class MissingElement{
    public static int search(int arr[]){
       int first = 0, last = arr.length - 1,mid;
       while(last - first >= 2){
          mid = first + (last - first)/2;
          if(arr[first]-first != arr[mid] - mid) {
            last = mid;
          }
          else 
            first = mid;
       }
       return (arr[first] + arr[last])/2;
  

  }
  
  public static void main(String args[]){
   int arr[] = {1, 2, 3, 4,5, 6, 7, 8, 9, 11, 12,13,14,15,16,17,18,19,20};
   
   System.out.println("Missing element is" + search(arr));
   
  
  }
}