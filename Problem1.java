class Problem1{

  public void missingNumber(int[] arr){
    int n = arr.length - 1;
    int sumOfArr = (n+1) * (n + 2)/2;
    int sum = 0;
    for(int i : arr)
      sum += i;
    System.out.println(sum - sumOfArr);

  }
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 8};
    Problem1 p1 = new Problem1();
    p1.missingNumber(arr);
  }
}
