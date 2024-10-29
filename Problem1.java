//Missing number in a sorted array
//[1,2,4,5,6,7,8]
// 0 1 2 3 4 5 6

import java.util.*;
class Solution{
   

   public static int findMissing(int[] nums)
   {
        int low=0;
        int high=nums.length-1;

        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if((nums[mid]-mid)>1)
            {  
               if((nums[mid-1]+1)!=nums[mid])
               {
                return nums[mid-1]+1 ;
               }
               else{
                high=mid-1;
               }

            }
            else{
                if((nums[mid]+1)!=nums[mid+1])
                {
                    return nums[mid]+1;
                }
                else{
                    low=mid+1;
                }
            }
        }
        return -1;
   }

   public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter array size");
      int n=sc.nextInt();
      System.out.println("Enter the array elements");
      int[] arr=new int[n];
      for(int i=0;i<n;i++)
      {
        arr[i]=sc.nextInt();
      }

      int f=findMissing(arr);
      System.out.println("Missing element is :"+f);

   }
}