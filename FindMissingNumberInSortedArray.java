
//Time Complexity: O(logn)
//Space Complexity: O(1)

/*
Problem: Given a sorted array of size n with distinct numbers in the range [1, n] with only one element missing, return the missing number.
Approach:
1. Apply binary search to find the midvalue
2. If the midvalue=midIndex+1 continue with the right half of the array
3. If the midValue>midIndex+1 move search space to the left half
*/

class FindMissingNumberInSortedArray{

    public static int findMissing(int nums[]){

        int low=0;
        int high=nums.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            int midValue=nums[mid];

            if(midValue>mid+1)
                high=mid-1;

            else
                low=mid+1;
        }
        return low+1;
    }
    public static void main(String args[]){

        // int nums[]={1,2,3,4,6,7,8}; //Missing no: 5

        int nums[]={1,2,3,4,5,6,7}; //Missing no: 8
        int res=findMissing(nums);
        System.out.println("Missing no: "+res);
    }
}