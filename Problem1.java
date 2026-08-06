class GfG {

    static int missingNumber(int[] arr) {
       int h = arr.length-1;
      int l = 0;
      int leftmissing = leftBinraySearch(arr, 0, l);
      if(leftmissing != -1) return leftmissing;
      int rightMissing = rightBinarySearch(arr, 0, 1);
      return rightMissing;
    }
  	private int leftBinraySearch(int[] arr, int l, int h) {
   		while(l <= h) {
         int mid = l + (hi - l) /2;
          if(arr[mid-1] +1 != arr[mid]) {
           return arr[mid] -1;
          } else if(arr[mid+1] -1 != arr[mid]) {
            return arr[mid]+1;
          } else {
           h = mid -1; // binary left search
          }
        }
      return -1;
    }

  private int rightBinarySearch(int[] arr, int l, int h) {
    while(l <= h) {
         int mid = l + (hi - l) /2;
          if(arr[mid-1] +1 != arr[mid]) {
           return arr[mid] -1;
          } else if(arr[mid+1] -1 != arr[mid]) {
            return arr[mid]+1;
          } else {
           l = mid +1; // binary right search
          }
        }
      return -1;
  }
  	

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 7, 8};
        System.out.println(missingNumber(arr));
    }
}
