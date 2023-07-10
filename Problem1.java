
// Time Complexity : O(nlogn)
// Space Complexity : O(1)
// Did this code successfully run on geeksForGeeks : yes
// Any problem you faced while coding this : no
//Applied binary search approach
public class Problem1 {
        static int search(int ar[], int size)
        {
            // Extreme cases
            if (ar[0] != 1)
                return 1;
            if (ar[size - 1] != (size + 1))
                return size + 1;
            int low = 1;
            int high = size-1;
            while(low<=high){
                int mid = low + (high-low)/2;
                System.out.println(mid);
                if(mid==ar[mid-1]){
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
            return high+1;
        }

        // Driver Code
        public static void main(String[] args)
        {
            int ar[] = { 1, 3, 4, 5, 6 };
            int size = ar.length;
            System.out.println("Missing number: "
                    + search(ar, size));
        }
}
