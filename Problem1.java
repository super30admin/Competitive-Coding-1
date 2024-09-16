//Missing Element
//Time complexity : O(logn)
//Space complexity : O(1)
public class Main {
    public static int getMissing(int arr[]) {
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[low]==arr[mid])
            break;
            if(arr[low]-low != arr[mid]-mid)
            high = mid;
            else
            low = mid;
        }
        return arr[low]+1;
    }

    public static void main(String args[]){
        int arr[] = {1,2,3,5,6};
        int result = getMissing(arr);
        System.out.println(result);
    }
}
