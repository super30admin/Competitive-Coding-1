//Time Complexcity:(logn)
//Space Complexcity O(1)
public class MissingElement {
   
    public static int search(int nums[]){
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            //find where missing element is present? on left or right
            int mid = low+(high -low)/2;
            if(nums[mid] - nums[low] == mid){//All elements are present on the left side; therefore, move to the right side and check for any missing elements.
                //before setting low ptr, check if missing element is left or right of mid element?
                if(nums[mid]+1 != nums[mid+1]) return nums[mid]+1;
                if(nums[mid]-1 != nums[mid-1]) return nums[mid]-1;
                low = mid+1;

            } else{
               // All elements are present on the right side; therefore, move to the left side and check for any missing elements.
                //before setting high ptr, check if missing element is left or right of mid element?
                if(nums[mid]+1 != nums[mid+1]) return nums[mid]+1;
                if(nums[mid]-1 != nums[mid-1]) return nums[mid]-1;
                high = mid-1;
            }

        }

        return -1;

    }
}

