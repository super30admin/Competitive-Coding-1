//Time complexity O(LogN) - N no of elements in an array
//space complexity - O(1)  - No extra space is required here
// Used binary search mentod to check whether mid value is eaual to mid+1
//if equal then the missing number may be in second half and not in the first half of the array.
//then move low to mid+1;
//if mid value is greater to mid+1. then missing will be on right half of the array . so h is moved to mid;
//if less then l is moved to mid;
//at last when l==h then it returns the next index of the missing element . so return a[mid]-1;

import java.io.*;

class MissingNumber{
    public static int find(int[] a){
        int l=0,h=a.length-1,m=0;
        
        while(l<=h){
            m=l+(h-l)/2;
            if(l==h){
                return a[m]-1;
            }
            if(a[m]==m+1){
                l=m+1;
            }
            else if(a[m]>m+1){
                h=m;
            }
            else{
                l=m;
            }
        }
        return a[m]-1;
    }
    
	public static void main (String[] args) {
		int a[] = {2,3,4,5,6,7};
		int p;
		p=find(a);
		System.out.println(p);
		return;
	}
}

