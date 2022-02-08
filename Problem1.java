import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    int[] arr = new int[]{1, 2, 3, 5, 6, 7, 8};
	    int n = arr.length;
	    int sum_n = ((n + 1) * ( n + 2)) / 2;
	   
	    int temp = 0;
	    for(int i=0; i<arr.length; i++){
	        temp = temp + arr[i];
	    }
	    
	    System.out.println(sum_n - temp);
	}
}
