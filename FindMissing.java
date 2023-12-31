// Time Complexity is o(logn) and space Complexity is o(1)
public class FindMissing {
    public static void main(String args[]){
        int[] arr ={4,6,7,8,9,10};
        int low=0,high=arr.length-1;
        
        int missing=0;
        while(high-low>=2)
        {
            int mid = low+(high-low)/2;
            int lowmiddiff = Math.abs((Math.abs(low-arr[low]))-(Math.abs(mid-arr[mid])));
            int highmiddiff= Math.abs((Math.abs(high-arr[high]))-(Math.abs(mid-arr[mid])));
            if(lowmiddiff > highmiddiff)
            {
                high=mid;
            }
            else if(lowmiddiff<highmiddiff)
            {
                low=mid;
            }
        }
        missing = (arr[low]+arr[high])/2;
        System.out.println(missing);
    }

    
}
