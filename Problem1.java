// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class Problem1 {
    public static int MissingElement(int[] array)
    {
        int low = 0;
        int high = array.length - 1;
        
        while(low<high)
        {
            int mid = (low+high)/2;
            
            if((array[mid-1] != (array[mid]-1)))
            {
                return (array[mid]-1);
            }
            
            else if((array[mid+1] != (array[mid]+1)))
            {
                return (array[mid]+1);
            }
            
            else if(array[mid] == mid + array[0])
            {
                low = mid + 1;
            }
            
            else
            {
                high = mid - 1;
            }
        }
        
        return 0;
    }
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 6, 7, 8};
		int missingElement = MissingElement(array);
		System.out.println("Missing Number is: "+missingElement);
    }
}