//Problem : Given a sorted array, from 1 to n, there's a missing number. Find the missing number if there exists one, else return -1

/** Time Complexity: O(logn) as we are using binary search on the array
 * Space Complexity: O(1)
 * Any Issues Coding this: None
 * Approach: 1. We apply binary search to find the missing element.
 * the difference between the missing element and the element before it will always be greater than 1 ,i.e., 2 . this will the search condition to find the missing element.
 * to divide the search space, we will check if the difference between the index of the mid element and the element at mid position is equal to 1. if it is equal to one, this makes it clear that there is no missing element in between left and mid indices. so we bring left to mid+1
 * else we bring the right pointer to mid minus 1.
*/
class Main {
    public int findMissing(int[] nums)
   {
       int l=0;
       int r=nums.length-1;
       while(l<=r)
       {
           int mid = l+(r-l)/2;
           if(mid>0 && nums[mid]-nums[mid-1]>1) return nums[mid-1]+1;
           else if((nums[mid]-mid)==1) l=mid+1;
           else r=mid-1;
       }
       return -1;
   }
   public static void main(String[] args) {
       int[] nums=new int[]{1,2,3,4,5,7};
       Main obj = new Main();
       System.out.println("missing element="+obj.findMissing(nums));
   }
}