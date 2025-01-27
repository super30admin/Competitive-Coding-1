// Interview problem solution
// Finding the missing number based on binary search mid
// Then checking the index against the current mid to eliminate the half which is not needed
// TIme complexity of O(Log N)

public class MissingNumberUtil{
        public int findMissingNumber(int[] arr){
        int low = 0;
        int high = arr.length - 1;
        
        while(low <= high){
            int mid = (low + high) / 2;
            
            if(arr[mid] - arr[mid-1] == 2){
                 //System.out.println(arr[mid-1] + 1);
                 return arr[mid-1] + 1;
            }
            else if(arr[mid+1] - arr[mid] == 2){
                //System.out.println(arr[mid] + 1);
                return arr[mid] + 1;
            }
            if((arr[mid] - mid) > 1){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        
    }
    
}
public class Main {
    public static void main(String[] args) {
       int[] arr = {1, 2, 4, 5, 6, 7, 8, 9};
       MissingNumberUtil util = new MissingNumberUtil();
       int result = util.findMissingNumber(arr);
      System.out.println(result);
    }
    

}