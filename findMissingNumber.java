
import java.util.*;

public class MissingNumber{

    public static void main(String []args){

        int inputArr[] = new int[]{0,1,2,3,4,5,6,7};
        int inputArr1[] = new int[]{1,2,3,5,6,7};
        int inputArr2[] = new int[]{0,1,2,3,4,6};
        int inputArr3[] = new int[]{1,2,3,4,5,6,7};
        int inputArr4[] = new int[]{2,3,4,5,7};
        int inputArr5[] = new int[]{-4,-3,-2,0};



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