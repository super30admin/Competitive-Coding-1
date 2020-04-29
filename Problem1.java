//Time Complexity: o(logn)
//space complexity o(1)

public class MissingNumber{
    
    public int CalMissingNumber(int[] arr){
        
        if(arr == null || arr.length==0)
        return -1;
        
        int low = 0, high = arr.length-1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            if(mid == 0 || (arr[mid]-arr[mid-1]!=1))
                {
                    return arr[mid]-1;
                }
            if(mid == arr.length-1 || (arr[mid+1]-arr[mid]!=1))
                {
                    return arr[mid]+1;
                }
            if((mid-low)!=(arr[mid]-arr[low]))
                high = mid -1;
            else if((high-mid)!=(arr[high]-arr[mid]))
                low = mid + 1;
        }
        return -1;
    }

     public static void main(String []args){
         int[] arr ={1,2,3,4,6,7,8};
         MissingNumber m = new MissingNumber();
        System.out.println("Missing Number: "+ m.CalMissingNumber(arr));
     }
}
