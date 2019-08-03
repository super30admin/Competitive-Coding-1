class Main
{

  static int findmissing(int arr[], int N){
      int l = 0;
      int r = N - 1;

      int m;
      while (l <= r){


      m = l + (r - l)/2;

      if(arr[m] != m + 1 && m == arr[m - 1]){
        return (m + 1);
      }

      if(arr[m] != m + 1){
        r = m - 1;
      }
      else{
        l = m + 1;

      }
    }
      return -1;
  }

// if no element is missing


// Driver code
public static void main(String [] args)
{
    int arr[] = {1, 2, 3, 4, 5, 7, 8};
    int N = arr.length;
    System.out.println(findmissing(arr, N));
}
}