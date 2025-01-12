
// i missing element in between the array
// Time complexity : O(log n)
// Space complexity : O(1)

#include <iostream>
#include <vector>

using namespace std;

int MissingElement(vector<int> nums)
{
    if (nums.empty())
    {
        return -1;
    }

    int low = 0, high = nums.size() - 1;

    while (low <= high)
    {

        if (high - low == 1 && nums[high] - nums[low] != 1)
        {
            return nums[low] + 1;
        }

        int mid = low + (high - low) / 2;

        if (nums[low] - low != nums[mid] - mid)
        {
            high = mid;
        }
        else
        {
            low = mid;
        }
    }

    return -1;
}

int main()
{
    vector<int> data = {1, 2, 3, 5, 6, 7, 8};

    int result = MissingElement(data);
    if (result != -1)
    {
        cout << "Missing element is " << result << endl;
    }
    else
    {
        cout << " There are no missing elements" << endl;
    }

    return 0;
}