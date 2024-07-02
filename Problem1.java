
/*
 * Brute force: 
 * Linear Search: 
 * Iterate over the given array and check if diff with adjacent element is > 1 
 * then find avg of 2 elemts and return the value.
 *  TC:O(N) SC: O(1)
 * 
 * Optimized: 
 * Binary Search: 
 * Check which half contains the missing number 
 * by checking if the diff between the index of mid and left and diff between value at mid and left is different.
 * if so move r to mid and search left ignore right.
 * Else move l to mid and check right ignore left
 * When r-l index diff is 1 you know that the missing value lies between element at l and r so take avg of the 2 elements and return as that is the missing element.
 * Else return -1 if missing element is not found. 
 * Time Complexity: O(logN) 
 * Space Complexity:O(1)
 */
public class Main {
    public static void main(String[] args) {
        int arr1[] = {1,3,4,6,7,8};
        System.out.println(missingElement(arr1));
        int arr2[] = {3,5};
        System.out.println(missingElement(arr2));
        
    }
    
    private static int missingElement(int[] arr) {
        int l = 0;
        int r = arr.length-1;
        
        while(r>l) {
            int mid = l + (r-l)/2;
            
            if(mid - l != arr[mid] - arr[l]) {
                r = mid;
            } else {
                l = mid;
            }
            
            if(r-l == 1) {
                return ((arr[r] + arr[l])/2);
            } 
            
        }
        return -1;
    }
}
