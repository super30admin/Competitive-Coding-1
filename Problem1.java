// "static void main" must be defined in a public class.
public class Main {
    
    public static int search(int arr[],int low,int high)
    {
        low = 0;
        high = arr.length-1;
        
        while(high>=low)
        {
            int mid = low+(high-low)/2;
            
            int diff = arr[mid]-mid;
            
            if(low==high)
            {
                return arr[high]-1;
            }
            
            if(arr[high]-high !=diff)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        
        return 9876;
    }
    
    public static void main(String[] args) {
        
        int arr[] = {1,2,3,4,5,6,8};
        
        int num = search(arr,0,arr.length-1);
        
        System.out.println("Missing Number is: "+num);
    }
}