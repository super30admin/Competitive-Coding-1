/*
Time Complexity: O(log n)
Space Complexity: O(1)

Find Missing Number in a sorted array
https://youtu.be/LwmckBrlrRs
 */
public class FindMissingElement
{
    public static int search(int[] arr, int size) {
        int low = 0, high = size - 1, mid = 0;

        while(high-low>=2) //If the element is missing between a range, the difference will be 2 or more
        {
            mid = low + ((high - low) / 2);
            int lowIndexDiff = arr[low]-low;
            int midIndexDiff = arr[mid]-mid;

            if(midIndexDiff != lowIndexDiff) {
                high = mid;
            }
            else{
                low = mid;
            }
        }

        return (arr[low] + arr[high])/2;
    }

    public static void main(String[] args)
    {
        int[] arr = {3,4,5,6,8};
        int size = arr.length;

        System.out.println("Missing Number is: "+ search(arr, size));
    }
}
