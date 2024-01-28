public class MyClass {
    public static void main(String args[]) {
      int[] nums = {2,3,4,5,6,7,8};
      int n = 8;
      MyClass obj = new MyClass();
      System.out.println(obj.findMissingElement(nums, n));
    }
    
    private int findMissingElement(int[] nums, int n) {
        int low = 0;
        int high = n - 1;
        
        while (low < high) {
            int mid = low + (high - low)/2;
            
            if (nums[mid] == mid + 1) {
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        
        return low + 1;
    }
}
