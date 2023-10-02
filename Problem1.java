// TC : O(n)
// SC: O(1)
class findmissing{
    public int missing(int[] nums){
        int n = nums.length;
        int lo = 0, hi = n - 1,mid = 0;
        while(lo < hi){
            mid = lo + (hi - lo)/2;
            if(nums[mid]==mid+1)
                lo = mid + 1;
            else
                hi = mid - 1;
            
        }
        if(mid!=0 && nums[mid]!=nums[mid-1]+1)
            return nums[mid]-1;
        if(mid!=n-1 && nums[mid]!=nums[mid+1]-1)
            return nums[mid]+1;
        return nums[hi]+1;
    }
    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,5};
        findmissing ob = new findmissing();
        int ans = ob.missing(arr);
        System.out.println(ans);
        int[] arr1 = new int[]{1,2,3};
        int ans1 = ob.missing(arr1);
        System.out.println(ans1);
        int[] arr2 = new int[]{1};
        int ans2 = ob.missing(arr2);
        System.out.println(ans2);

    }
}