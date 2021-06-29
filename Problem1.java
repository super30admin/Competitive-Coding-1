class Solution
{
public int searchMissingValue(int arr[],
                  int size)
{
    int lo = 0, hi = size - 1;
    
    while (lo<=hi)
    {
        int mid = lo+(hi-lo)/2;
        if ((arr[lo] - lo) != (arr[mid] - mid))
            hi = mid;
        else if ((arr[hi] - hi) != (arr[mid] - mid))
            lo = mid;
    }
    return (arr[lo] + 1);
}
 
// Driver Code
public static void main (String[] args)
{
    int arr[] = { 1, 2, 3, 4, 5, 6, 8 };
    int size = arr.length;
    System.out.println("Missing number: " +
                        searchMissingValue(arr, size));
}
}
