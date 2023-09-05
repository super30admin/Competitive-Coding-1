import java.util.Arrays;

class MissingElementInArray {
    //It is given array will start from 0 and goes till n.
    //SC will be O(1)
    //TC will be O(log n), where n is number of elements in the array.
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);  //to sort the array
        int low=0;
        int high=nums.length-1;

        if(nums==null || nums.length==0){       //Array is empty return -1.
            return -1;
        }

        while(low<=high){
            int mid=low+(high-low)/2;   //to prevent integer overflow situation
            if(nums[mid]!=mid){         //In sorted array with adjacant value is one size greater then mid index will be equivalent to mid value and missing value will be on left hand side.
                high=mid-1;
            }
            else{
                low=mid+1;           //If mid value is equal to num[mid] then missing value must be on right side.
            }
        }
        return low;         //return low where low high will become same
    }


    public static void main(String[] args){
        MissingElementInArray obj= new MissingElementInArray();
        int[] nums={0,1,2,4,5};
        System.out.println(obj.missingNumber(nums));
    }
}