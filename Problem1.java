/*package whatever //do not write package name here */
//Time Complexity = O(log(n))
//Space Complexity = O(1)
import java.io.*;

class GFG {
    public static int search(int[]nums,int size){
        int l =0;
        int h = size-1;
        int mid;
        while(l<h-1){
            mid = l + (h-l)/2;
            if(nums[mid]-nums[l]!=mid-l){
                h = mid;
            }
            else if(nums[h]-nums[mid]!=h-mid){
                l = mid;
            }
        }
        return (nums[h]+nums[l])/2;
    }
	public static void main (String[] args) {
		int ar[] = {  6, 8 };
        int size = ar.length;
        System.out.println("Missing number:" +
                        search(ar, size));
	}
}