
public class Main {    public static void main(String[] args) {
      System.out.println("Hello World");
      int arr[]={1,2,3,4,5,6,7,8};       System.out.println(binSearch(arr));    }
   public static int binSearch(int arr[]){
      int l=0;
      int h=arr.length-1;       while(l<=h){
           int mid=l+(h-l)/2;
          if(arr[mid]==mid+1) {
              l=mid+1;
          }
          else{
              h=mid-1;               if(mid==0 || arr[mid-1]-mid==0 ){                   return mid+1;
              }
          }
      }
   return -1;
  }
}
//TC:O(logn)
//SC:O(1)
