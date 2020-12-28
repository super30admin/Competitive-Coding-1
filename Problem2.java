class Problem2 {

    // Nilesh Deokar
    // Time : O(lg(n))
    // Space : O(1)
    public static void main(String[] args){

      // int[] arr = {1, 2, 3, 4, 5, 6, 7, 9};
      // int[] arr = {1, 3, 4, 5, 6, 7, 8, 9, 10};
      		// int[] arr = {1,2,4,5,6,7,8,9};
      		// int[] arr = {1,2,3,4,5,6,8,9};
      		// int[] arr = {2,3};
      		// int[] arr = {1,3,4};
       int[] arr = {1,2,4};
      System.out.printf("Missing number is : %d \n",findMissingElement(arr));
    }

    public static int findMissingElement(int[] arr){
      if(arr == null || arr.length < 2) return -1;
      int low = 0;
      int high = arr.length - 1;
      int pivot = 0;

      // if diff between low and high becomes 2 then we are sure, missing element is in closed range

      while(high - low >= 2){
        pivot = low + (high - low)/2;
        int pdiff = arr[pivot] - pivot;
        int ldiff = arr[low] - low;
        int hdiff = arr[high] - high;

        if(ldiff != pdiff){
          // if low and pivot diff doesn't match search in left half
            high = pivot;
        }else if(hdiff != pdiff){
          // if high and pivot diff doesn't match search in right half
            low = pivot;
        }
      }
      return (arr[low] + arr[high]) / 2;

    }

  }
