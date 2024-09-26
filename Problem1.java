//link - https://www.geeksforgeeks.org/find-missing-element-in-a-sorted-array-of-consecutive-numbers/
class Problem1{

    public static void main(String[] args) {
        // Missing Number
        int[] nums = {7,9,10,11,12,13};

        int low = 0;
        int high = nums.length - 1;
        int flag = 0;

        while(low <= high){

            int mid = low + (high - low)/2;

            if(nums[0] + mid == nums[mid]){ // mid is consistent i.e left part is sorted

                //Checking with immediate next element
                if(mid != nums.length - 1&&nums[mid + 1] - nums[mid] > 1){
                    System.out.println("Missing Number is:"+(nums[mid] + 1));
                    flag = 1;
                    break;
                }
                low = mid + 1;

            }else{ // mid is not consistent i.e left part is unsorted

                if(mid != 0 && nums[mid] - nums[mid] > 1){
                    System.out.println("Missing Number is:"+(nums[mid] - 1));
                    flag = 1;
                    break;
                }
                high = mid - 1;

            }
        }

        if(flag == 0){
            System.out.println("No missing number");
        }

    }
}
