// time complexity: O(log n)
// space Complexity : O(1)


public class Solution{

    public int FindMissingNumber(int[] arr)
    {
        int low = 0,high=arr.Length-1;

        while(low<=high){
            int mid = low + (high - low)/2;

            if(arr[mid] == mid+1){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low+1;

    }

}

public class Program{
    public static void Main(string[] args){
        Solution obj = new Solution();
        int[] arr = new int[] {1,2,3,4,6,7,8};
        int result = obj.FindMissingNumber(arr);
        Console.WriteLine(result);
    }
}
