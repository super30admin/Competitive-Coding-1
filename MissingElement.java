// Find the sum of 1 to n => n (n+1) /2; find sum of elements => sum => sum - Nsum gives x; O(n)

//binary search - find element whose index != index+1 return (index+1); if arr[mid] != mid +1 missing on left side else right side
// O(log N)
 
class MissingElement {

    public int findMissing(int[] nums, int low, int high){
        
        if(low > high)
            return -1;
        
        int mid = low + (high-low)/2;

        if((mid == 0 && nums[mid] != mid+1) || (nums[mid] != mid+1 && nums[mid-1] == mid)){
            return mid+1;
        }

        if(nums[mid] != mid+1) {
            high = mid-1;
            return findMissing(nums, low, high);
        }
        else{
            low = mid+1;
            return findMissing(nums, low, high);
        }       
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,6};
        MissingElement obj = new MissingElement();
        int low = 0;
        int high = nums.length-1;
        System.out.println(obj.findMissing(nums, low, high));
    }

}