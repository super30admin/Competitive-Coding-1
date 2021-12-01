#include <iostream>
#include <vector>

using namespace std;


// Time Complexity : O(logn)
// Space Complexity : O(1)
// Problem : Came up with the approach but found some issues while writing the code

int getMissingElement(vector<int> nums)
{
    int low = 0;
    int high = nums.size() - 1;
    int mid = low + (high - low) / 2;
    if(nums[low] - low == 1 && nums[high] - high == 1 && nums[mid] - mid == 1)
    {
        return nums.size() + 1;
    }
    while(low <= high)
    {
        mid = low + (high - low) / 2;
        if(nums[low] - low > 1 || nums[mid] - mid > 1)
        {
            high = mid - 1;
        }
        else if(nums[high] - high > 1)
        {
            low = mid + 1;
        }
    }
    return mid + 1;
}
int main() 
{
    vector<int> temp{ 2, 3 , 4 , 5 , 6 , 7 , 8, 9};
    cout << getMissingElement(temp) << endl;
}
