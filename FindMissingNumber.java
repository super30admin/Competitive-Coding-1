class FindMissingNumber
{
	public int findMissingNumber(int nums[])
	{
        if(nums == null || nums.length == 0)
            return NOT_FOUND;

        int length = nums.length;

        int low = 0;
        int high = length -1;

        while( low <= high )
        {

            int mid  = low + (high - low)/2;

            if(nums[low] - low > 1)
                high = mid -1;
            else
                low = mid +1;
        }
        if(low < length)
            return nums[low] -1;
        else
            return nums[--low] + 1;

	}


    public static void main(String[] args)
    {
        FindMissingNumber findMissingNumber = new FindMissingNumber();

        int input1[] = new int[]{1,2,3,5,6};
        int input2[] = new int[]{2,3,4,5,6};
        int input3[] = new int[]{1,2,3,4,5};

        System.out.println("input 1::  " + findMissingNumber.findMissing(input1));
        System.out.println("input 2:: " + findMissingNumber.findMissing(input2));
        System.out.println("input 3:: " + findMissingNumber.findMissing(input3));
    }
}
