//Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, 
//One of the integers is missing in the list
//Write a code to find the missing integer.
//Time Complexity: O(log n)
//Space Complexity: O(1)
class Missing_number{
   
    public int missing(int[] arr){
        int low=0;
        int high=arr.length-1;
        
        if(arr[0] - 0 >1) return 1;
        while(low <= high ){
            int mid = low + (high-low)/2;
            if(arr[mid]!=mid+1 && arr[mid-1]==mid){
                return mid+1;
            }
            if(arr[mid]==mid+1)low=mid+1;
            else high=mid-1;
        }
        return -1;
    }
    }
    public class Problem1 {
        public static void main(String[] args) {
            Missing_number miss = new Missing_number();
            int[] arr = new int[]{1,2,3,4,6,7};
            int[] arr1 = new int[]{2,3,4,5,6,7};
            int[] arr2 = new int[]{1,2,3,4,5,6,7};
            int result = miss.missing(arr);
            int result1 = miss.missing(arr1);
            int result2 = miss.missing(arr2);
             System.out.println(result);
             System.out.println(result1);
            System.out.println(result2);
        }
    }