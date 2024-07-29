// Find the Missing Number in a sorted array 
// Time complexity = O(log(n))
// Space complexity = O(1)
// Reduce the search space by 1/2
// go towards the sorted array.

class Problem1 {

    public static void main(String [] args) 
    { 
        // a = [1,3,4,5,6,7,8];
        // find the missing integer
        // binary search
        int a[] = { 1, 2, 3, 4, 5, 6, 8 };
        int low = 0;
        int high = a.length-1;// 7
        while(low<=high) { // low and high . check for the last number as well
            int mid = low + (high-low)/2; // overflow condition.// index.
            // numbers - 1, 2, 3, 4, 5, 6, 8
            // index -   0, 1, 2, 3, 4, 5, 6
            // what we understand is a[i]-i=1 for all other integers except where it is missing and onwards then.
            if(a[mid]-mid>1) {// go towards the sorted ones.
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        System.out.println(low+1);


    }

}
