# Time Complexity : O(klogk) where k = length of the longest string(s)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

// 

#include <iostream>
using namespace std;
int missing(int arr[])
{
    int size = arr.size();
    int low = 0, high = size-1, mid =0;
    while(high-low >= 2)
    {

            
        mid = low + (high -low) /2;
        int  midIDiff = arr[mid] - mid;
        int  lowIDiff = arr[low] - low;
        int  highIDiff = arr[high] - high;

        if (midIDiff != lowIDiff)
            high = mid;
        else if (midIDiff != highIDiff)
            low = mid;
        
    }
    return (arr[low] + arr[high])/2;

}
int main()
{
    int nums[] = { 1, 2, 3, 4, 5, 6, 8 };
    cout<< "Missing No.:" << missing(nums);
}





/* MY VERSION:

#include <iostream>
using namespace std;
int missing(int arr[])
{
    int n = 7;
    int low = 0, high = n-1;
    while(low<high)
    {

            
        int mid = low + (high -low) /2;
        
        if (mid+1 == arr[mid])
            low = mid +1;
        else 
            high = mid -1;
        
    }
    return (arr[low] - 1);

}
int main()
{
    int nums[] = { 1, 2, 3, 4, 5, 6, 8 };
    cout<< "Missing No.:" << missing(nums);
}


*/






