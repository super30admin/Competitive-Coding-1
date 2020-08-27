/* 
Provide an array of n-1 integers in the range of 1 to n with no duplicates 
in list, One of the integers is missing in the list. 
Write a code to find the missing integer.

Examples:

Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
Output : 4

Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]
Output : 3
-------------------------------------------------------

Approach - compare mid element with index. If it is equal to mid-1 then search to right of mid.
           if difference between mid element and index is greater than 1 then search to right of array. 
Time Complexity - O(Logn) - N size of array
Space Compxity - O(1)
*/
#include <iostream>
#include <vector>

using namespace std;

class Sol {
public:
    int binarySeacrh(vector<int> nums) {
        int start = 0;
        int end = nums.size() - 1;
        
        while (start <=end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == mid + 1)
                start = mid + 1;
            else if (nums[mid] - mid > 1)
                end = mid - 1;
           
        }
        return nums[start] - 1;
    }
};

int main()
{
    //std::cout << "Hello World!\n";
    vector<int> nums{2,3,4,5,6,7};
    Sol s;
    cout << s.binarySeacrh(nums) << endl;

}

