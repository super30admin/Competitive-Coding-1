//Time complexity:O(logn)
//Space complexity:O(1)
//find the missing element in a sorted array

class Problem1
{
    static int search(int arr[],int size)
{
    int low = 0, high = size - 1;
    int mid = 0;
    while ((high - low) > 1)
    {
        mid = (low + high) / 2;
        if ((arr[low] - low) != (arr[mid] - mid))
            high = mid;
        else if ((arr[high] - high) != (arr[mid] - mid))
            low = mid;
    }
    return (arr[low] + 1);
}
 
// Driver Code
public static void main (String[] args)
{
    int arr[] = { 1, 2, 3, 4, 5, 6, 8 };
    int size = arr.length;
    System.out.println("Missing number: " +
                        search(arr, size));
}
}


