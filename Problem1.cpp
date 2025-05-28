#include<bits/stdc++.h>
using namespace std;
#include <bits/stdc++.h>
using namespace std;

int missingNumber(vector<int> arr)
{
    int n = arr.size();
    if (arr[0] != 1)
        return 1;
    if (arr[n - 1] != (n + 1))
        return n + 1;
    int low = 0, high = n - 1;
    while (low<high) {
        int mid = low + (high-low) / 2;
        if ((arr[low] - low) != (arr[mid] - mid))
            high = mid;
        else if ((arr[high] - high) != (arr[mid] - mid))
            low = mid;
    }
    return (arr[low] + 1);
}

int main()
{
    vector<int> arr = { 1, 2, 3, 4, 6, 7, 8 };
    cout << missingNumber(arr);
}