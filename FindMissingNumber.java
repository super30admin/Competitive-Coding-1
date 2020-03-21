class FindMissing{

public int findMissingPositive(int[] arr)
    {
        int low=0, high = arr.length-1;
        while(high-low>=2)
        {
            int mid=low+(high-low)/2;
            int midIdxDiff=arr[mid]-mid;
            int lowIdxDiff=arr[low]-low;
            int highIdxDiff=arr[high]-high;
            if(lowIdxDiff != midIdxDiff)
                high=mid;
            else if(highIdxDiff != midIdxDiff)
                low=mid;
        }
        return (arr[low]+arr[high])/2;
    }
}
