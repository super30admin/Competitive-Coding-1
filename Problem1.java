/*
Time - O(logn)
Space - O(1)
*/
public class Problem1{
    public static void main(String []args){
       System.out.println("Hello World");
       int[] a = new int []{1,2,3,4,5,8};
       System.out.println(missingElement(a));
    }
//Java
public static int missingElement( int [ ] arr){
int low = 0;
int high = arr.length-1;
int mid;
while( low<=high){
   mid = low + (high-low) /2;
   if (arr[mid] != mid + 1 && arr[mid - 1] == mid) return mid + 1;         
   if(arr[mid]- mid ==1){
   low = mid+1;}
   else high = mid;
}
return -1;
}
}
