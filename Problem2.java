
//  time complexity: O(logn)
        //space complexity: O(1)

class missingnumberinsortedarray //performing binary search and finding the missing number
{
    static int search(int ar[],
                      int size)
    {
        int a = 0, b = size - 1;
        int mid = 0;
        while ((b - a) > 1)
        {
            mid = (a + b) / 2; //computing difference and finding the missed element
            if ((ar[a] - a) != (ar[mid] - mid))
                b = mid;
            else if ((ar[b] - b) != (ar[mid] - mid))
                a = mid;
        }
        return (ar[a] + 1);
    }
}