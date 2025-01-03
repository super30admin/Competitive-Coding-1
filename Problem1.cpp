

// Problem Name: Interview Problem: Find Missing Number in a sorted array
// Binary Search
// Time Complexity: O(log n)

#include <iostream>
#include <vector>
using namespace std;
int findMissingElement(vector<int> &nums)
{
    int length = nums.size();
    int low = 0;
    int high = length - 1;
    // Check the case where no missing element is present in the array
    if (nums[length - 1] != length)
    {
        while (low <= high)
        {
            // Calculate mid
            int mid = low + (high - low) / 2;
            // If mid is in the correct position, the missing element must be in the right half
            if (nums[mid] == mid + 1)
            {
                low = mid + 1;
            }

            // Otherwise, the missing element is in the left half
            else
            {
                high = mid - 1;
            }
        }
        // The missing element is at the position 'low + 1'
        return low + 1;
    }
    return -1;
}
int main()
{
    vector<int> nums = {1, 2, 3, 4, 5, 6, 8};
    int res = findMissingElement(nums);
    cout << res << endl;

    return 0;
}