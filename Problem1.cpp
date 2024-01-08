//Question: Find the missing number in the sorted array.

// Time Complexity : O(logn)
// Space Complexity : O(1)
// Any problem you faced while coding this : no.


// Your code here along with comments explaining your approach
// Second approach idea is to use binary search. We first find mid and then calculate number of missing elements between two indexes
// and then adjust the low/high accordingly. At the end return mean of the low and high array elements.

#include <vector>
#include <set>
#include <iostream>

// Helper function to find the missing number
int findMissingNumber(std::vector<int>& v)
{
    int low = 0;
    int high = v.size() - 1;
    int mid = 0;
    
    // Atleast 2 elements are needed to check missing number
    while((high - low) >= 2)
    {
        mid = low + (high - low)/2;
        // Calculate how much mid is off with its element.
        int midIdxDiff = v[mid]- mid;
        // Calculate how much low is off with its element.
        int lowIdxDiff = v[low] - low;
        
        // If lowIdxDiff is different from midIdxDiff which means number is missing from left side of array
        if(lowIdxDiff != midIdxDiff)
        {
            high = mid;
        }
        else // If midIdxDiff is different from highIdxDiff, which means number is missing from right side of array.
        {
            low = mid;
        }
    }
    // return the mean of latest low and high to get the missing number.
    return ((v[low]+v[high])/2);
}

int main()
{
    std::vector<int> vec = {1, 2, 3, 4, 5, 6, 8, 9};
    
    std::cout << "Missing number is - " << findMissingNumber(vec) << std::endl;
}

