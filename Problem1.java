// "static void main" must be defined in a public class.
// Find missing number in sorted array
// Time Complexity : O(logn)
// Space Complexity : O(1)
public class Problem1 {
    
    public static int bsearch(int []arr)
    {
        int low = 0;
        int high = arr.length-1;
        
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(arr[mid]!=mid+1)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
            
        }
        return low+1;
    }
    public static void main(String[] args) {
        int []arr = {2,3,4,5,6,7,8,9};
        int missing = bsearch(arr);
        System.out.println(missing);
    }
}
