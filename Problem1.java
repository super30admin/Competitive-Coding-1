
public class Problem1{

    public int missingElement(int[] arr){
        int n = arr.length;
        int low  = 0;
        int high = n-1;
        int mid;

        while (low<=high){
            mid = low + (high-low)/2;
            if(mid + 1  == arr[mid]){
                low = mid + 1;
            }else{
                high = mid-1;
            }
        }

        return arr[low] -1;
    }

    public static void main(String[] args){

        int[] arr = {1,2,3,5,6,7,8,9,10,11,12};
        System.out.println("Missing element : " + missingElement(arr));
    }
}

