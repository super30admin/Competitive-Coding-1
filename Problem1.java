// Time Complexity :O(n) if array is unsorted and O(log n) if sorted. n is the array size;
// Space Complexity : O(1) since the input elements of the array are constant;
// Did this code successfully run on Leetcode : Yes, I have covered basic edge cases
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class MissingNumber {

    public static void main(String []args){
       int[] arr = new int[]{0, 2, 1, 4, 6, 5, 7};
       System.out.println(findNum(arr));
       
    }
    
    //function to find the missing number
    public static int findNum(int[] nums)
    {
       int high = nums.length-1;
       int low = 0;
       if(nums.length==0 || nums==null)
       {
           return 0;
       }
       //checking if list is sorted
       if(nums[low]<=nums[high] && nums[low]>0)
       {
           while(high>low)
           {
               int mid = low + (high-low)/2;
               
               
               if(mid !=0 && nums[mid]-nums[mid-1]>1)
               {
                   return nums[mid] -1;
               }
               
               else if (mid != nums.length-1 && nums[mid+1]-nums[mid]>1)
               {
                   return nums[mid] +1;
               }
               
               if(nums[mid]-nums[low]==mid-low)
               {
                   low = mid;
               }
               else
               {
                   high = mid;
               }
           }
           
           return nums[0] +1;
           
       }
       //Unsorted array
       else
       {
           int sum1 =0;
           int sum2 =0;
           
           for (int i =0;i<nums.length;i++)
           {
               sum1 = sum1 +nums[i];
           }
           
           for (int i =0;i<=nums.length;i++)
           {
               sum2 = sum2 +i;
           }
           
           return sum2- sum1;
       }
       
    }
}