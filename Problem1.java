//time - O(log n)
//space O(1)
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int result = findMissing(new int[]{2});
        System.out.println("Missing Nnumber :" + result);
    }

    public static int findMissing(int [] nums){
        //edge
        if(nums == null || nums.length == 0){
            return -1;
        }
        int low = 0;
        int high = nums.length -1;

        if(nums[low] !=1){
            return 1;
        }

        while(low<=high){
            int mid = (high + low)/2;
            System.out.println(mid);
            if(nums[mid]- mid <=1){
                low = mid +1;
            }else if (nums[mid]- mid > 1){
                high = mid - 1;
            }
        }
        System.out.println(low + " : " + high);
        return low +1;
    }
}
