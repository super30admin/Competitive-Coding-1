public class FindTheMissingSortedArrayS30 {

  public int findMissingElement(int[] arr)
  {
    if(arr==null || arr.length==0 || arr.length==1)
    {
      return -1;
    }
    int high = arr.length-1;
    int low = 0;
    while(high-low>=2) {
      int mid = low + (high - low) / 2;
      int midDiff = arr[mid]-mid;
      int lowDiff = arr[low]-low;
      int highDiff = arr[high]-high;
      if(midDiff != highDiff)
      {
        // right side
        low = mid;
      }
      else {
        high = mid;
      }
    }
    return arr[low]+arr[high]/2;

  }

}

class Solution1 {
  public static void main(String[] args) {
    FindTheMissingSortedArrayAgain a = new FindTheMissingSortedArrayAgain();
    System.out.println(a.findMissingElement(new int[]{1,2,3,4,5,6,8}));

  }
}
