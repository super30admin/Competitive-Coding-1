

// //Given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list. One of the integers is missing in the list. Write an efficient code to find the missing integer. 
// Examples: 

// Input : arr[] = [1, 2, 3, 4, 6, 7, 8]
// Output : 5


// Input : arr[] = [1, 2, 3, 4, 5, 6, 8, 9]
// Output : 7

// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
         // Faced difficulty in considering different usecases and return statement.
// Your code here along with comments explaining your approach in three sentences only:
        //The numbers in array are 1 value more than their indices, using this relation the 
        //conditions for binary search were decided.




class Main {
    public static int findMissing(int[] a){
        int l=0;
        int h=a.length-1;
        while(l<=h)
        {
            int m=l+(h-l)/2;
            if(a[m]>m+1)
               {
                h=m-1;
               }
               else
               {
                l=m+1;
               }    
        }
        return l+1;
    }
    
    public static void main(String[] args) {
        int[] a={1,2,4,5,6};
        int missing=findMissing(a);
        System.out.println("The missing number is: "+missing);
    }
}
