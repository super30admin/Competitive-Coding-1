//In Bruteforce we traverse all the elements in the  inout array so time complexity would be O(n) and
// space complexity would be O(1) as we dont use any extra space.
//In Optimal solution we divide elements by binary search so time complexity is O(log n) and space complexity is till O(1)

class Problem1{

// Bruteforce Solution
//  public void missingNumber(int[] arr){
//    int n = arr.length - 1;
//    int sumOfArr = (n+1) * (n + 2)/2;
//    int sum = 0;
//    for(int i : arr)
//      sum += i;
//    System.out.println(sum - sumOfArr);
//
//  }

   public void missingNumber(int[] arr){
     int low = 0;
     int high = arr.length - 1;
     int mid = (low + high)/2;
     while((high - low) > 1) {
        mid = (low + high)/2;
        if((arr[low] - low) != (arr[mid] - mid))
          high = mid;
        else if((arr[high] - high) != (arr[mid] - mid))
          low = mid;
     }
     System.out.println(arr[mid] + 1);
   }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 8};
    Problem1 p1 = new Problem1();
    p1.missingNumber(arr);
  }


}
