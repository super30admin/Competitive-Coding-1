
/* The idea is to use index to decide which part of the array there will be missing element and then traverse accordingly*/

class solution{
    
    public static void main(String [] args) {
	//code
	 int[] nums = {0,1,2,3,5,6};
	 //int[] nums = {1};
	System.out.println(search_missing(nums));
	
}

public static int search_missing(int[] nums){
   
	//Arrays.sort(nums);
        
    int l = 0;
    int r = nums.length - 1;
        
        
    if(nums == null || nums.length < 1)
        return -1;
        
    if(nums.length == 1 && nums[0] == 0)
        return 1;
        
    return search(nums,l,r);
}
public static int search(int[] a , int l , int r){
    int mid = (l + r)/2;
        
        if(l <= r){
            
            if(a[mid] != mid)
                return mid;
            
            if(a[mid] == mid)
                return search(a,mid+1, r);
            else
                return search(a,l,mid - 1);
        
        }
        return -1;

    
}
    
    
    
}


