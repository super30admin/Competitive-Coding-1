
/**
 * Time Complexity : O(log N), Space Complexity: O(1)
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static int findMisssing(int[] arr){
    int low = 0, high = arr.length-1;
    while(low <= high){
      
      int mid = low + (high-low)/2;
      
      if((mid)!=0 && arr[mid-1] != arr[mid] -1) return arr[mid]-1;
      if((mid)!=arr.length-1 && arr[mid+1] != arr[mid] +1) return arr[mid]+1;
      
      if(arr[mid] - arr[low] +1 != (mid-low+1)){
        high = mid -1;
      }
         
      else{
        low = mid +1;
      }
      
      
    }
    
  
         return -1;
         
         }

  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    int[] ar = new int[]{1, 2, 3, 4, 5, 6, 8, 9};
    System.out.println("Missing ele: "+ findMisssing(ar));

    
  }
}
