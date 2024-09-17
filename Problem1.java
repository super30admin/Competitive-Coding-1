/**

// Time Complexity : O(logn) 
// Space Complexity : O(1) since there is no additional space used.
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

**/
class Practice {
    
    public static void main(String args[])
    {
        System.out.println(searchMissing(new int[]{1, 2, 4, 5, 6, 7, 8, 9}));
    }
   
    public static int searchMissing(int input[])
    {
        int start = 0;
        int end = input.length - 1;
        
        while((end - start) > 1)
        {
            int mid = start + (end - start) / 2;
            
            if (input[mid+1] - input[mid] != 1)
            {
                return input[mid] + 1;
            }
            
            if (input[mid] - input[mid - 1] != 1)
            {
                return input[mid] - 1;
            }
            
            if (((input[mid] - input[start]) + 1) > (mid - start) + 1)
            {
                end = mid;
            }
            else
            {
                start = mid;
            }
        }
        
        return -1;
    }
}