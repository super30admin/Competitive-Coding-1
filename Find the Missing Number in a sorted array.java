public class FindTheMissingSortedArrayAgain {

  public int findMissingElement(int[] arr)
  {
    if(arr==null || arr.length==0 || arr.length==1)
    {
      return -1;
    }
    int high = arr.length-1;
    int low = 0;
    int base = arr[0];
    int end = arr[arr.length-1];
    while(low<=high) {
      int mid = low + (high - low) / 2;
      if(arr[mid] == base+mid )
      {
        if(arr[mid+1] == arr[mid]+1)
        {
        // right side
        low = mid+1;
        }
        else {
          return arr[mid]+1;
        }
      }
      else {
        if(arr[mid] == arr[mid-1]+1)
        {
          high = mid-1;
        }
        else {
          return arr[mid]-1;
        }
      }
    }
    return -1;

  }
}

 class Solution
{
  public static void main(String[] args)
  {
    FindTheMissingSortedArrayAgain a = new FindTheMissingSortedArrayAgain();
    System.out.println(a.findMissingElement(new int[]{22,23,24,25,26,27,29}));

  }
}

