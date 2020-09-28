import java.util.Arrays;

public class Problem1 {
    public static void main(String args[]){
        int[] t1={2,3,4,5,6,7,8};
        int[] t2={1,3,4,5,6,7,8};
        int[] t3={1,2,3,4,6,7,8};
        int[] t4={1,2,3,4,5,6,8};
        System.out.println("Missing number in "+Arrays.toString(t1)+" "+Integer.toString(findMissingNumber(t1)));
        System.out.println("Missing number in"+Arrays.toString(t2)+" "+Integer.toString(findMissingNumber(t2)));
        System.out.println("Missing number in"+Arrays.toString(t3)+" "+Integer.toString(findMissingNumber(t3)));
        System.out.println("Missing number in"+Arrays.toString(t4)+" "+Integer.toString(findMissingNumber(t4)));
    }

    private static int findMissingNumber(int[] arr){
        int l = 0;
        int r = arr.length-1;
        int mid;

        while(l<r){
            mid = l + (r-l)/2;
            if(arr[mid]==mid+1){
                l = mid+1;
            }
            else{
                r = mid;
            }
        }
        return arr[l]-1;         
    }
}