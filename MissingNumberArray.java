//Find missing number in sorted array

class solution {

    public static void main(String[] args)
    {
        int[] array = {1,2,3,4,5,6,8};
        int size = array.length;
        System.out.println("Missing number", search(array, size));
    }

    public static int search(int array[], int size)
    {
        int low = 0;
        int high = size -1;
        int mid = 0;
        while(high - low > =2) 
        {
            mid = (high-low) /2;
            int midIndexDiff = array[mid] - mid;
            int lowIndexDiff = array[low] - low;
            int highIndexDiff = array[high] - high;
            if(midIndexDiff != lowIndexDiff) {
                high = mid;
            } 
            else if(midIndexDiff != highIndexDiff) {
                low = mid;
            }
        }
        return (arr[low] + arr[high])/2;
    }
}
