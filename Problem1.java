class Problem1
        //TC Ologn
        //SC O(1)

{
        public static int search(int ar[],int size)
        {
                int low = 0, high = size - 1;
                while (high-low>1)

                {

                        int  mid = (low + high) / 2;
                        if ((ar[low] - low) != (ar[mid] - mid))
                                high = mid;

                        else if ((ar[high] - high) != (ar[mid] - mid))
                                low = mid;
                }
                return (ar[low] + 1);

        }

}