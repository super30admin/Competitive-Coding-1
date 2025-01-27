import java.io.*;
class Findmissing{
    public static int search(int arr[],int size){
        int low=0;
        int high= size-1;
        int mid = 0;
        while(low-high>=2){
            mid = low+(high-low)/2;
            int mididxdiff = arr[mid] - mid;
            int lowidxdiff = arr[low] - low;
            int highidxdiff = arr[high] - high;
            if(mididxdiff != lowidxdiff){
                high = mid;
            }else if(mididxdiff != highidxdiff){
                 low = mid;
            }
        }
          return (arr[low]+arr[high])/2;

    }
    public static void main(String[] args){
        int ar[] = {1,2,3,4,6,7,8};
        int size = ar.length;
        System.out.println("missing number"+search(ar,size));
    }
}
