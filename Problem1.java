class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    int [] arr= new int[] {1, 2, 3,4,5,6, 7,8};
    findMissing(arr);
  }
  public static void findMissing(int [] arr){
int low=0;
    int high= arr.length-1;
    if(arr.length==0){
      System.out.println(-1);
    }
    if(arr[0]>1){
      System.out.println(1);
    }
    if(arr[arr.length-1]==arr.length){
      System.out.println(arr.length+1); 
    }
    while(low<=high){
      int mid= low +(high-low)/2;
      if(arr[mid]> mid+1 &&(mid>0 && arr[mid-1]!=mid)){
        high=mid-1;
      }else if(arr[mid]> mid+1 &&(mid>0 && arr[mid-1]==mid)){
        System.out.println(mid+1) ;
        break;
      }else low=mid+1; 
      
    }
  }
  
}
//Time Complexity: O(Log n)
