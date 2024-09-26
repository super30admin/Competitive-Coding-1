
//Program tofind missing element in sorted array
//time complexity: getmin:  : O(logn)
//space complexity:o(1)

/**
 *
 * @author skalse
 */
public class Missing_Number {
    
    
static int binarySearch(int ar[], int size)
    {
        int low = 0;
        int high = size - 1;

        while (low<=high)
        {
            int mid = low + (high - low)/2;
            if (ar[mid]-mid==1){
                low = mid+1    ;               
            }
            else{ 
                high = mid-1;
            }
        }

        // return the missing element
        return low+1;
    }

    public static void main (String[] args)
    {
        int ar[] = {1,3,4,5,6,7,8};
        int size = ar.length;
        System.out.println("Missing number: " + binarySearch(ar, size));
    }
    
}
