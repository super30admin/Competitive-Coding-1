
class Solution {

  public static int getMissing(int[] arr) {

    int s = 0;
    int e = arr.length - 1;
    while (s<e) {

      int mid = (s+e) /2;
      if(arr[mid - 1] != arr[mid]-1) {
        return arr[mid] -1;
      }

      if(arr[mid + 1] != arr[mid]+1) {
        return arr[mid] + 1;
      }

      if (arr[mid] - arr[s] != mid - s) {
        e = mid -1;
      } else if (arr[e] - arr[mid] != e - mid) {
         s = mid+1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6,8};
    System.out.println(getMissing(arr));
  }

}
