
//Find Missing Number in a sorted array

//Idea is to do binary search and eliminate 
//one half of the array if the number of elements does not match the size.
class Problem1 {

    //Time Complexity: O(log(n))
    // Space Complexity: O(1)
 public static int FindMissingNumber()
    {
        int[] arr = {1,2,3,4,5,6,8};
       int m = arr.length;
       
       int low = 0;
       int high = m-1;

       while(low+1<high)
       {
          int mid  = low+(high-low)/2;

          int leftpositionaldifference = mid-low;//size of the search space
          int leftvaluedifference = arr[mid]-arr[low];//no.of elements in search space

          if(leftpositionaldifference!=leftvaluedifference)
          {
            high = mid; 
          }
          else{
          low = mid;
            }
        }

        return (arr[low]+arr[high])/2;
    }

    public static void main(String[] args)
    {
        System.out.println(FindMissingNumber());
    }
}