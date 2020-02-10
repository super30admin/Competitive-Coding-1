
public class FindMissing {
	public static void main (String[] args) {
	    int nums[] = { 1,2,3,4,5,6,7,8,9,10,12};
        int ans = findMissing(nums);
        System.out.println(ans);
		
	}
	public static int findMissing(int nums[]){
	    if(nums== null || nums.length == 0){
	        return -1;
	    }
	    int low = 0, high = nums.length -1;
	    int mid = low + (high-low)/2;
	    while(low < high){
	        mid = low + (high - low)/2;
	        if((nums[mid] - mid) >1){
	            high = mid-1;
	        }
	        else{
	            low = mid+1;
	        }
	    }
	    return nums[mid]+1;
	}

}
