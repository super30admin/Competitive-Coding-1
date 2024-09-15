// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class MissingNumber{
    public static int findMissingNumber(int[] arr,int size)
    {
        int low=0;
        int high=arr.length-1;
        //the difference of first element and the first index would remain same for all the elements that are perfectly placed.
        int difference=arr[0]-low;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if((arr[mid-1]-(mid-1)==difference) && (arr[mid]-mid)>difference)
            return arr[mid]-1;
            else if(arr[mid]-mid==difference)
            low=mid+1;
            else high=mid;
        }
        return -1;
    }
    public static void main(String[] args)
    {
        int ar[] = { 1,2,4};
        int size = ar.length;
        System.out.println("Missing number: " + findMissingNumber(ar, size));


    }
}
