// Time Complexity :O(logn)-Binary Search
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Problem not available on leetcode
// Any problem you faced while coding this : No
class MissingNumber
{
    public static int search(int[] A)
    {
        //search function
        int l =0,h=A.length-1;
        while(h-l!=1)
        {
           
            int mid = l+(h-l)/2;
            if(A[mid]-A[l]!=mid-l)
            {
                //missing part
                h=mid;
            }
            else{
                //missing part
                l=mid;
            }
        }
        return (A[h]+A[l])/2;
    }
    public static void main(String args[])
    {
        // int[] A = new int []{1,2,4,5,6};
        int ar1[] = { 1, 2, 3, 5, 6, 7, 8 }; //4
        int ar2[] = { 4, 5, 6, 7, 8, 9, 11}; //10
        int ar3[] = { 0, 1, 2, 4 }; //3
        int ar4[] = { 2, 4 }; //3
        int ar5[] = { 0, 2, 3, 4 }; //1 
        int ar6[] = { 2, 3, 5, 6, 7, 8, 9}; //4

        System.out.println(search(ar1));
        System.out.println(search(ar2));
        System.out.println(search(ar3));
        System.out.println(search(ar4));
        System.out.println(search(ar5));
        System.out.println(search(ar6));
    }
}