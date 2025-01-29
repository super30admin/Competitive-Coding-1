// Time Complexity: O(logn)
// Space complexity: O(1)

#include <iostream>
using namespace std;

int search(int ar[], int size)
{
    if (ar[0] != 1)
        return 1;
    if (ar[size - 1] != (size + 1))
        return size + 1;

    int low = 0, high = size - 1;
    int mid;
    while ((high - low) > 1) {
        mid = (low + high) / 2;
        if ((ar[low] - low) != (ar[mid] - mid))
            high = mid;
        else if ((ar[high] - high) != (ar[mid] - mid))
            low = mid;
    }
    return (ar[low] + 1);
}

int main()
{
    int ar[] = { 1, 2, 3, 4, 5, 6, 8 };
    int size = sizeof(ar) / sizeof(ar[0]);
    cout << "Missing number:" << search(ar, size);
}