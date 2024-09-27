public class Problem1 {
    public static void main(String[] args) {
        
        int[] arr = {1,2,3,5,6,7,8,9}; 
        int low = 0 , high = arr.length - 1;
        int mid =0;
        int result = 0, target = 0;
        while(low<=high){ 
            mid = low + (high - low) / 2; 
            target =mid + 1;
            if(arr[mid]==target){
                low = mid +1;
            }
            else if(arr[mid]>target) {
                        high = mid-1;
                        result = mid + 1;
            }
            else{
                high = mid - 1;
                result = mid + 1;
            }
        }
    System.out.println("Missing integer from 1 to n : " + result);
    }      
}