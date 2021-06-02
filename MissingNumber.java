
// Time Complexity : O(log n)
// Space Complexity : O(1)

public class MissingNumber{
    public static int findMissingNumber(int[] arr,int size)
    {
        int low=0;
        int high=arr.length-1;
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
        int ar[] = { 1,2,3,4,5,6,7,9};
        int size = ar.length;
        System.out.println("The imssing number is: " + findMissingNumber(ar, size));


    }
}