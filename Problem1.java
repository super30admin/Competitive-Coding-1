class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    int [] arr = {1, 2,3,4, 5, 6, 7, 9};
    int i=0;
    int midPoint=0;
    int j=arr.length-1;
    while(i<=j){
      midPoint=i+(j-i)/2;
      if(arr[midPoint]-midPoint>1){
        if(midPoint==0 ||arr[midPoint]-arr[midPoint-1]>1){
          System.out.println(arr[midPoint-1]+1);
          return;
        }
        j=midPoint-1;
      }else{
        i=midPoint+1;
      }
    }
  }
  
}
