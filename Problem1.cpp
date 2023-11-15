class Solution {
public:
    int missingNumber(vector<int>& nums) {
    //Sort the array
        sort(nums.begin(),nums.end());
int low = 0 , high = nums.size() - 1;
while(low<= high)
{
    int mid = low + (high - low)/2;
    if((mid == 0) || (nums[mid - 1] != (nums[mid] - 1 )))
    {
        return (nums[mid] - 1);
    }
    else if((mid == nums.size()-1) || (nums[mid + 1]  != ( nums[mid] + 1)))
    {
        return (nums[mid] + 1);
    }
    if((nums[mid] - nums[low]) == (mid - low))
    {
        low = mid + 1;
    }
    else
    {
        high = mid - 1;
    }
}
return -1;
    }
};
