/**
Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.
Examples:
Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
Output : 4
Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]
Output : 3
**/


public class Problem1 {
    public int findMissingElement(int [] a){
        int n = a.length;
        int sum = findSum(a);
        int expectedSum = n * (n +1)/2;
        return expectedSum-sum;
    }

    public int findSum(int [] a){
        int sum = 0;
        for (int i = 0; i<a.length; i++){
            sum += a[i];
        }
        return sum;
    }

    public int findMissingElement2(int a[]){
        int l = 0;
        int h = a.length-1;
        while(l<=h){
            int m = l + (h-l)/2;
            if(a[m]== m){
                l=m+1;
            } else{
                h=m-1;
            }
        }
        return h+1;
    }

    public static void main (String args[]){
        Problem1 obj = new Problem1();
        int[] a = new int []{0, 2, 3, 4, 5, 6};
        System.out.println(obj.findMissingElement2(a));
    }
}    