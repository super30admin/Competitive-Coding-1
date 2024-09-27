//find missing number in sorted array
//given an array of sorted numbers, find the missing element: (input: 1. even, 2. odd 3. negative 4. semi neg)


public class findMissingElement {
    public static int binarySearch(int []arr, int l, int h){
        while((h-l)>1){
            int mid=l+(h-l)/2;
            if ((arr[l] - l) != (arr[mid] - mid))
                h= mid;
            else if ((arr[h] - h) != (arr[mid] - mid)) 
                l = mid; 
        }
        return arr[l]+1;
    }
    public static void main(String[] args) {
        int arr[]=new int[]{1,2,3,4,5,6,8};
        int l=0;
        int h=arr.length-1;
        System.out.println("the missing element is "+ binarySearch(arr, l, h));
    }
}
