
class GFG
{
static int search(int [] ar, int N)
{
     
    int l = 0, r = N - 1;
    int mid = 0;
   
    while (r-l>=2)
    {
        mid = l+(r-l)/2;
        int midDiff = ar[mid] - mid;
        int l_IdxDiff = arr[l] - l;
        int h_IdxDiff = arr[h] - h;
        if (midDiff!=l_IdxDiff) {
        	h = mid;
        }else if(midDiff!=h_IdxDiff) {
        	l = mid;
        }
    }
    return (ar[l]+ar[h])/2;
}
 
// Driver code
public static void main(String [] args)
{
    int arr[] = {1, 2, 3, 4, 5, 7, 8};
    int N = arr.length;
    System.out.println(findmissing(arr, N));
    
    int arr2[] = {1, 2, 3, 5, 6, 7, 8};
    int N2 = arr2.length;
    System.out.println(findmissing(arr2, N2));
}
}
