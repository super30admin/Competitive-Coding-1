//T:O(log(n)
//S:O(1)

class Main {  
	public static void main (String[] args)
{
  int arr[] = { 1, 2, 3, 4, 5, 6, 8 };
	int arr1[] = { 1, 3};
	int arr2[] = { 3, 4, 5, 6, 8 };
    System.out.println("Missing number: " +search(arr));
	System.out.println("Missing number: " +search(arr1));
	System.out.println("Missing number: " +search(arr2));

  } 


public static int search(int arr[])
{
   	int l = 0, h = arr.length - 1;
    int mid = 0;
    while ((h - l) > 1)
    {
        mid = l + (h - l) / 2;
		int lDiff=arr[l] - l;
		int hDiff=arr[h] - h;
		int midDiff=arr[mid] - mid;
        if (lDiff != midDiff)
            h = mid;
        else if (hDiff != midDiff)
            l = mid;
    }
    return arr[l] + 1;
}
}
