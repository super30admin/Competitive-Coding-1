// Time Complexity : O(logn)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

#include<iostream>
#include<math.h>

using namespace std;

int main()
{
    int arr[] = {0, 1, 2, 4, 5, 6, 7};

    int n = sizeof(arr) / sizeof(int);

    int l = 0;
    int r = n-1;
    int m = -1;

    while(l <= r)
    {
        m = l + floor((r-l)/2);

        if(arr[m] > m)
        {
            r = m-1;
        }
        else
        {
            l = m+1;
        }
    }

    cout << endl << l << endl;

    return 0;
}