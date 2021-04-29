/*A modified binary search was used to serve the purpose of 
finding the missing number in the array
Difficulty faced - by updating the high,low through mid-1,mid+1 respectively, the missing element was prone to be missed
this was addressed by updating low and high with the mid itself.*/
public class MissingNumber{

    public static void main(String args[]){
        int []arr = {1,2,3,4,6,7,8};
        int res = binarySearch(0,arr.length-1,arr);
        System.out.println("The missing element is "+res);
    }
    private static int binarySearch(int low,int high,int[] arr){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[0]!=1) return 1;
            if(arr[arr.length-1]!=arr.length+1) return arr.length; 
            if(arr[mid]==mid+1){
                low = mid;
            }
            else if(arr[mid]>mid+1){
                high = mid;
            }else{
                low = mid;
            }
            if(high-low==1){
                return arr[low]+1;
            }
        }
        return 0;
    }
}
