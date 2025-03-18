// Problem Name: Interview Problem: Find Missing Number in a sorted array

class Problem1{
    
    /*public int missingNumber(int[] arr, int n){
        int i=0;
        while(i<n && arr[i] == i+1){
            i++;
        }
        return i+1;
    }*//* Time complexity - O(n) */

    public int missingNumber(int[] arr, int n){/* Time complexity - O(log(n)) *//* Space complexity - O(1) */
        int low = 0, high = n-1;
        int mid = 0;
        while(low < high){
            mid = low + (high - low)/2;
            if(arr[mid] == mid + 1){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low + 1;
    }

    public static void main(String[] args){
        int[] arr = {1,2,4,5,6,7};
        int n = arr.length;
        Problem1 obj = new Problem1();
        System.out.println(obj.missingNumber(arr, n));
    }
}