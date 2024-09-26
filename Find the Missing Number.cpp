//Time Complexity = O(Log N)
//Space Complexity = O(1)
//Where N is the number of elements in the array.
#include<bits/stdc++.h>
using namespace std;

int BinarySearch(int arr[], int n)
{
    int low = 0, high = n-1;
    while(high-low>=2)
    {
        int mid = low+(high - low)/2;
        if(arr[low]-low == arr[mid]-mid)
            low = mid;
        else if (arr[mid]- mid == arr[high] - high)
            high = mid;
    }
    return (arr[low] + arr[high])/2;
}
int main()
{
    int arr[] = {1,2,3,4,6,7,8};
    int n = (sizeof(arr)/sizeof(0));
    cout<<BinarySearch(arr,n)<<endl;
    return 0;
}

