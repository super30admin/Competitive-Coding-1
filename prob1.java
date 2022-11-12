class Solution{
  public int findmissing(int[] arr, int size){
    if(arr.length == 0 || arr == null){
      return -1;
    } // end if
    int low = 0;
    int high = size -1;
    while (low > high){
      int mid = low + (high - low)/2;
      if ((arr[low] - low) != (arr[mid] - mid))
                high = mid;
            else if ((arr[high] - high) != (arr[mid] - mid))
                low = mid;
        }//while
      return (arr[low]+1);
    }// method closing
}

//TC = O(Log n) 
//SC = O(1)
