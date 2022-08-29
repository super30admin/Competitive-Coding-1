
public class MockWeek1 {
      //tc- ologn
    //sc-o(1)
    public static void main(String args[])
    {
        int[] arr ={3,5,6,7};
        int i = find(arr);
        System.out.println(i);

    }
    public static int find(int arr[])
    {
        int low = 0;
        int high = arr.length-1;
        while(high-low >= 2)
        {
            int mid = low+(high-low)/2;
            int midddiff = arr[mid] - mid;
            int lowdiff = arr[low] - low;
            int highdiff = arr[high] - high;
            if(lowdiff != midddiff)
            {
                high = mid;
            }
            else if (highdiff != midddiff){low = mid;}
        }
        return (arr[low]+arr[high])/2;
    }
    
}
