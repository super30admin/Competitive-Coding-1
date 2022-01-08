//missing element in a sorted array
//tc log n
//sc 1
class Solution {
  
  public int MissingNumber(int[] arr) {
    
    int low = 0;
    int high = arr.length -1;
    
    while(high - low + 1 > 2){
      
      int mid = low + (high - low) / 2;
      
      if(arr[low] - low != arr[mid] - mid) {
        
        high = mid;
        
      }
      else if(arr[high] - high != arr[mid] - mid){
        
        low = mid;
        
      }
    
    }
    return arr[low] + 1;
  }
}
