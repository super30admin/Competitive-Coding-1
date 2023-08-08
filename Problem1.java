
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes on my compiler
// Any problem you faced while coding this : No
class FindMissingElement{

    public static int FindElement(int[] arr)
    {
     int len =  arr.length;
     int low = 0, high =len-1;
 
     if(arr[0]!=1) return 1;
     else if(arr[len-1] != (len+1)) return len+1;
     else 
     while(low<high){
      int mid = low+(high-low)/2;
      if(arr[mid]- mid >1)
      {
         high = mid;
      }
      else{
         low = mid+1;
      }
     }
     return low+1;
     
    }
 
    public static void main(String[] args)
    {
     int[] arr = {1,2,4,5,6,7,8}; //  missing element on left array
     int[] case1 = {2,3,4,5,6,7,8}; // left Edge case
     int[] case2 = {1,2,3,4,5,6,7,8}; //right Edge Case
     int[] case3= {1,2,4,5,6,8}; //  missing element on left array
     
     int notFound = FindElement(arr);
     int notFoundForCase1 = FindElement(case1);
     int notFoundForCase2 = FindElement(case2);
     int notFoundForCase3 = FindElement(case3);
     System.out.println(" The element not Found is: "+ notFound);
     System.out.println(" The element not Found for Case1  is: "+ notFoundForCase1);
     System.out.println(" The element not Found for Case2  is: "+ notFoundForCase2);
     System.out.println(" The element not Found for Case3  is: "+ notFoundForCase3);
    }
 
 }
