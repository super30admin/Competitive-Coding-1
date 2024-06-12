package mock;

//Time Complexity: O(logn)
public class MissingNumInSorArr {

    public int findMiss(int [] nums){
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        while(high - low >= 2){
            mid = low + (high - low)/2;

            int midIndDif = nums[mid] - mid;
            int lowIndDif = nums[low] - low;

            if(midIndDif != lowIndDif){
                //meaning missing number is on right of mid
                high = mid;
            }
            else{
                low = mid;
            }
        }

        return (nums[high] + nums[low]) / 2;
    }

    public static void main(String args[]){

        int nums[] = new int[]{3,5};

        MissingNumInSorArr ob = new MissingNumInSorArr();

        System.out.println("Missing element: "+ob.findMiss(nums));
    }
}
