/*
Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.

Examples:

Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
Output : 4

Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]
Output : 3
*/

// Time Complexity :
  //find elem: O(log n)
// Space Complexity :
  // O(1)
// Any problem you faced while coding this :
  //Nope
// Your code here along with comments explaining your approach
  //do binary search,
  //in case midelem == mid+1, we know its in right position and everything in
  //left subarray of it is also in right position, chk right subarray.
  //else chk left subarray.

  // detail:
  //chking for position and elem because we know array is sorted from 1 to n.
  //in case a value is missing, then value at indx+1 (indx from 0 to n-1),
  //will not be same as indx+1.
  //eg:
  //indx: 0, 1, 2, 3, 4
  //arr:  1, 2, 4, 5, 6
  // all elems are higher from indx+1 from Missing number's indx, i.e.
  //indx : 2 (2+1 = 3)  , 3 != actual val(4)
  //missing val:  3
import java.io.*;

class Problem1{
  static int search(int ar[], int size)
  {
    //size 0 return 0.
    if(size == 0)
      return 0;

    //do binary search
    int strt = 0;
    int end = size-1;

    while(strt <= end){
      //find mid
      int mid = strt + (end - strt)/2;

      //chk condition for search range.
      if(ar[mid] == mid + 1){
        strt = mid+1;
      }
      else{
        end = mid-1;
      }
    }
    //will be pointing at first miss match position.
    return strt + 1;
  }
  public static void main (String[] args)
  {
  	int ar[] = {1,2,3,5,6,7,8};
  	int size = ar.length;
  	System.out.println("Missing number: " +
  						search(ar, size));
  }
}
