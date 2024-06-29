
//Time complexity : O(N) - iterating through whole input array
//Space Complecity: O(1) - no new datastructure created
// "static void main" must be defined in a public class.
public class Problem2 {
    public static void main(String[] args) {
        //Find missing integer in an unsorted array
        int n=8;
        int sum = (n*(n+1))/2;
        int[] nums2= {1,2,8,5,7,6,4};
        for(int i=0;i<n-1;i++){
            sum=sum-nums2[i];
        }  
        System.out.println(sum);
    }
}