/* Time complexity: O(log n)
 * Space complexity: O(1)
 */

public class MissingElement {
    int nums[] = {1,2,3,4,5,6,7,8,9,10,11,13,14,15,16};
    int low = 0;
    int high = nums.length - 1;

    public void findMissing()
    {
    while(low + 1 < high)
    {
        int mid = low + (high - low)/2;

        if((nums[low] - low) == nums[mid] - mid)
        {
            low = mid;
        }
        else{
            high = mid;
        }
    }

    System.out.println((nums[low] + nums[high])/2);
}

    public static void main(String[] args)
    {
        MissingElement obj = new MissingElement();
        obj.findMissing();
    }    
}
