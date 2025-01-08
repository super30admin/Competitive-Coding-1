/*elements appearing before the missing element will have ar[i] – i = 1
and those appearing after the missing element will have ar[i] – i = 2*/

public class MissingElement {

    public int search(int arr[])
    {
        int l = arr.length;
        int low = 0;
        int high = l-1;

        while(low<=high)
        {
            int mid = low + (high-low)/2;

            if(arr[0]!=1)
            {
                return 1;
            }
            if(arr[l-1]==l)
            {
                return -1; //if no missing elements it returns -1
            }

            if(arr[mid]-1==mid)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }

        }
        return low+1;
    }

    public static void main(String[] a) {
        int[] nums = new int[] {1, 2, 3};
        MissingElement m = new MissingElement();
        System.out.println(m.search(nums));
    }
}



