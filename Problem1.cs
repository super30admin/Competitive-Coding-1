namespace Coding
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int[] arr = [11, 12, 13, 14, 16];

            var res = SearchNumber(arr);
            Console.WriteLine(res);
            Console.ReadLine();
        }

        static int SearchNumber(int[] nums)
        {
            int low = 0, high = nums.Length - 1;
            int offsetLeft = nums[low];
            int offsetRight = nums[high];
            while (high - low > 1)
            {
                int mid = low + (high - low) / 2;
                if (nums[mid] - mid != nums[low] - low)
                {
                    high = mid;
                }
                else
                {
                    low = mid;
                }
            }
            return nums[low] + 1;
        }
    }
}
