
// Time Complexity : O(log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
  //coded high=mid+1 initially then corrected my mistake

public class MissingElement {
  private int find(int[] a) {
      int low=0;
      int high= a.length-1;
      while(low<=high){
        int mid = low +(high-low)/2;
       //base case
        if(low == high)
          return a[mid]-1;

        if(a[mid]-1 == mid){
          low = mid+1;
        }
        else{
          high = mid;
        }
      }
    return -1;
  }
  public static  void  main(String[] args){
    int[] a = new int[]{1,2,4,5,6};
    MissingElement m = new MissingElement();
   int missing = m.find(a);
   System.out.println("missing is "+missing);
  }
}