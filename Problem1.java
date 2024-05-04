
/*
time complexity: O(log(n)) as we're dividing our search space into half in each iteration
space complexity: O(1) as we're not using any auxiliary data structure/extra space
did this run on leetcode? N/A
 */
public class Problem1
{
    public int findMissingElement(int[] arr)
    {
        int result = -1;
        //input validations

        if(arr == null || arr.length < 2)
        {
            return -1;
        }

        int low = 0;
        int high = arr.length -1;

        while(low < high)
        {
            int mid = low + (high -low)/2;

            if(high == low +1)
            {
                break;
            }
            if((arr[high] - arr[mid+1]) > (high - (mid +1)))
            {
                //search the right half of the list
                low = mid+1;
            }
            else
            {
                high = mid;
            }
        }
        result = arr[low] +1;
        return result;
    }

    public static void main(String[] args)
    {
        Problem1 obj = new Problem1();

        int[] input = {1,2,3,4,5,6,7,9};
        System.out.println(obj.findMissingElement(input));
    }
}


