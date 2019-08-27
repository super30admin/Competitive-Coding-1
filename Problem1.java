// In this problem the missing element is found by comparing the middif which is obtained by taking the difference between the middle element and the middle index with the startdif which is the difference between start element and the start index and enddif which is the difference between end element and end index. The start and the end are moved according in the direction where the differences don't match. At the end the missing element is determined to be the average between the start and the end elements. The solution is implemented in O(logN) time complexity and O(1) space complexity. The code is tested using the main function.


class Solution{
    public static void main(String[] args){
        Solution s= new Solution();
        int[] nums={1,2,3,4,6,7};
        int m= s.missingElement(nums);
        System.out.println("The missing number is :"+m);
    }
    public int missingElement(int[] nums){
        int start= 0;
        int end = nums.length-1;
        while(end-start>=2){
            int mid=start+(end-start)/2;
            int middif=nums[mid]-mid;
            int startdif=nums[start]-start;
            int enddif= nums[end]-end;
            if(middif!=startdif){
                end=mid;
            }
            else if(middif!=highdif){
                start=mid;
            }
        }    
        return nums[start]+nums[high]/2;
        
    }
}
