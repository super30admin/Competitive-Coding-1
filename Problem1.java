import java.io.*;
class GFG {
    static int MissingNumber(int[]arr1,int l,int h){
        while(l < h){
            int mid = l + (h - l)/2;
            if(arr1[mid] == mid + 1 && l != mid){
                l = mid;
            }
            else //if(arr1[mid] != mid + 1 && h != mid)
            h = mid;
        }
        return arr1[l] + 1;
    }
	public static void main (String[] args) {
		System.out.println("GfG!");
		
		int[] arr = {1,3};
		int l = 0;
		int h = arr.length - 1;
		int result = MissingNumber(arr,l,h);
		System.out.println("Missing number is!" + result);
	}
}
