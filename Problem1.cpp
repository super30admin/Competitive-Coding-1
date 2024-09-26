#include <iostream>
#include <vector>

using namespace std;


// Time Complexity : O(logn)
// Space Complexity : O(1)
// Problem : Came up with the approach but found some issues while writing the code

//Approach : Find the middle element
//           Check whether any of the indices of low mid or high have a difference of greater than 1
//           If low or mid have difference with indices greater than 1 then we can safely assume that
//           left half of the array has a missing element
//           If low or mid both have difference of 1 and high has difference greater than 1
//           then we can assume that missing element lies on the right half of array
//           Once mid / low / high are at the same position, we can return mid + 1 as missing element  
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
