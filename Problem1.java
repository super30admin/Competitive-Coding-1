// Online Java Compiler
// Use this editor to write, compile and run your Java code online
//Time complexity O(logn)
//Space complexity :constant time
class Main {
    public static void main(String[] args) {
        int a[] ={1,2,3,5,6,8};
        
        
        int low = 0;
        int high = a.length-1;
        int mid=0;
        
        while (low <= high) {
            mid = low + (high-low)/2;
            int numberOfElements = mid - low;
            if (high - low == 1) {
                System.out.println(a[low] + 1);
                break;
            }
            if (a[mid] == (a[low] + numberOfElements)) {
                low = mid;
            } else {
                high = mid;
            }
        }
        
    }
}
