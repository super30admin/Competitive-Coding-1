// Time Complexity : o(logn)
// Space Complexity : o(1)
// Mock 1 

public class Main {
    
    private static int findMissing(int[] arr){
        int low = 0;
        int high = arr.length -1;
        while(low<=high){
            int mid = low + (high-low)/2; 
            
            //Everything is well sorted before the mid so bring low to mid+1
            if(arr[mid] == mid+1){
                low= mid+1;
            }else{
            	//otherwise the problem is in the left part only
                high = mid -1;
            }
        }
        return arr[low]-1;
    }
    public static void main(String[] args) {
        
        int[] arr = {1,2,3,4,6,7,8};
        System.out.println(findMissing(arr));
        
    }
}
