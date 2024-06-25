
// "static void main" must be defined in a public class.
public class Problem1 {
    public static void main(String[] args) {
        int[] nums = new int []{1,2,3,4,6,7,8,9};
        int result = getMissing(nums);
       System.out.println(result);
    }
    
    public static int getMissing(int[] arr){
        int low = 0;
        int high = arr.length -1;
        
        while(low<=high){
            int mid = low+ (high-low)/2;
            if(arr[mid]!=mid+1 && ( arr[mid-1] == mid)){
                return mid+1;
            }
            if(arr[low] == 1+low  && arr[mid] == mid +1 ){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}