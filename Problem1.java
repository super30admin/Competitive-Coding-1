class Problem1
{
    static int search(int ar[], int size)
    {
        // Initialize low and high pointers
        int low = 0;
        int high = size - 1;
        while (high - low >= 2){
            // Initialize mid pointer
            int mid = low + (high - low) / 2;
            // Find difference between the pointers and their values
            int lowIndexDiff = ar[low] - low;
            int midIndexDiff = ar[mid] - mid;
            int highIndexDiff = ar[high] - high;

            // If a number is missing between any of two pointers, the diffence
            // between their corresponding index and value will not be constant
            if(lowIndexDiff != midIndexDiff){
                // Number is missing between low and mid
                // move left
                high = mid;
            }
            else if(highIndexDiff != midIndexDiff){
                // Number is missing between mid and high
                // move right
                low = mid;
            }
        }
        // find the missing number by taking average of values at low and high pointers
        return (ar[low] + ar[high]) / 2;
    }

    // Driver Code
    public static void main (String[] args)
    {
        int ar[] = { 1, 2, 3, 4, 5, 6, 8 };
        int size = ar.length;
        System.out.println("Missing number: " +
                search(ar, size));
    }
}
