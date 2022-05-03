import java.io.*;
public class MissingElement {
    public static int FindMissingElement(int arr[]) {
        int low = 0;
        int high = arr.length - 1;

        while(low<high) {
            int mid = low - (high-low)/2;

            if(arr[low]-low != arr[mid]-mid) {
                mid = high;
            }
            else if(arr[high]-high != arr[mid]-mid) {
                mid = low;
            }
        }
        return (arr[low] + 1);
    }

    public static void main (String[] args) {
        int arr[] = {1,2,3,5,6,7};
        System.out.println(FindMissingElement(arr));
    }
}