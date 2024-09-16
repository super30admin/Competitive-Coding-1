//Find missing number in sorted array starting from 1
//[1,2,3,4,6,7]-> 5 here

//Time Complexity : O(log n)
//Space complexity : O(1)

//Solution using binary search


public class MyClass
{
static int find(int nums[])
{
	int start = 0;
	int end = nums.length- 1;
	
	while((end - start) > 1)
	{
		int mid = start + (end-start) / 2;
		if ((nums[start] - start) != (nums[mid] - mid))
			end = mid;
		else if ((nums[end] - end) != (nums[mid] - mid))
			start = mid;
	}
	return (nums[start] + 1);
}

public static void main (String[] args)
{
	int nums[] = { 1, 2, 4, 5 };

	System.out.println(find(nums));
}
}
