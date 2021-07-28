
// Time Complexity : O(LogN)
// Space Complexity : O(1)
// Any problem you faced while coding this : Yes, during mock, however this is now fine


// Your code here along with comments explaining your approach
/*
Approach:
1) set low and high and calculate value at index
2) if lowIndex and midIndex are same, this means that there is no missing element and we need to search right side. so set low to mid
3) else set high to mid 

Imp condition run the loop till high -low>=2
thus there should be 1 element apart (Not 2 elements apart, as one of them is mssing)
avg of them gives that element 

*/
// This is will only on sorted array (positive and negative numbers in order only)



import java.util.*;

public class MissingNumber{

     public static void main(String []args){
         
         // array starts from 1 to N, thus 0 wont come as missing element, if all elements are present in array, case added.
         int inputArr[] = new int[]{0,1,2,3,4,5,6,7};
         int inputArr1[] = new int[]{1,2,3,5,6,7}; 
         int inputArr2[] = new int[]{0,1,2,3,4,6};
         int inputArr3[] = new int[]{1,2,3,4,5,6,7}; 
         int inputArr4[] = new int[]{2,3,4,5,7}; 
         int inputArr5[] = new int[]{-4,-3,-2,0};
         
         /*
            should return -1
            should return 4
            should return 5
            should return -1
            should return 6
         */
         
       
    System.out.println("Missing element is "+findMissing(inputArr));
    System.out.println("Missing element is "+findMissing(inputArr1));
    System.out.println("Missing element is "+findMissing(inputArr2)); 
    System.out.println("Missing element is "+findMissing(inputArr3)); 
    System.out.println("Missing element is "+findMissing(inputArr4));
    System.out.println("Missing element is "+findMissing(inputArr5));
     }
     
     public static int findMissing(int[] arr)
     {
         if(arr==null)
            return -1;
         else if(arr.length==1)
         {
             return -1;
         }
         
         
         int low=0;
         int high = arr.length-1;
         
         if((arr[low]-low)==(arr[high]-high))
        {
            return -1;
        }
         
         while(high-low>=2)
         {
             int mid = low+(high-low)/2;
             
             int lowIndex = arr[low]-low;
             int midIndex = arr[mid]-mid;
             int highIndex = arr[high]-high; // not needed as lowIndex and midIndex have been added
             
             if(lowIndex!=midIndex)
             {
                 high = mid; // missing number is in lower half as the differences should be equal, indicating there is no missing element and array is sorted
             }
             else 
             {
                 low= mid;
             }
             
             
             
         }
         
         return (arr[low]+arr[high])/2;
         
     }
}
