// T.C : O(logn)
// S.C : O(1)
public class Main {
    static int search(int[] ar, int size){

   int low=0;
     int high= size-1;
   // to check if no element missing, return-1
     if(ar[high]-high!= ar[low]-low){
     while(low<=high){
       int mid = low +(high-low)/2;
       if(ar[mid]-mid == 1){
           low = mid+1;
       }
       else{
           high = mid-1;
       }
   }
   }
   else{
       return -1;
   }
        return low+1;
    }
public static void main(String[] args) {
   int ar[] = {1,2,3,4,5,6,8};
   int size = ar.length;
   System.out.println(search(ar,size));
}
}