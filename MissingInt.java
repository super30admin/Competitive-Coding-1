// Problem : Finding missing element from sorted array
// 1 to n number
// no repeat
// 0 indexed
// only 1 number is missing

// Time Complexity O(log n)
// Space Complexity O(1) : No Auxillary space is being used
// Any challange : not as such. It took time to build the solution/logic
// Ran on leet code: I am not trace down leet code link so no, but this should work. Tested on local.


public class MissingInt {

    public int search(int[] arr){
        if(arr == null || arr.length ==0) return -1;
        int len = arr.length; // O(1)
        if(len == 1) return -1;

        int low=0;
        int high=len-1;
        int mid=0;
        
        while(low<=high){
            mid = low +( high - low)/2;
            
            if(arr[mid] != mid+1) {
                return mid+1;
            }else if(arr[low] == low+1 && arr[mid] == mid+1){
                low = mid +1;
            }else{
                high = mid-1;
            }
        }
        return -1; //if no missing elements
    }


    public static void main(String[] args) {
        MissingInt m = new MissingInt();
        //int[] array = {1,2,3,4,5,6,7,9,10};
        int[] array = {3};
        int  result = m.search(array);
        System.out.println(result);
    }
    
}
