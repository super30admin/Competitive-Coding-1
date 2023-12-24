/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <iostream>
#include <vector>

using namespace std;

int findMissingNumber(vector<int> &arr)
{
    int low = 0, high = arr.size() - 1, mid;

    while (low < high)
    {
        mid = low + ((high - low) / 2);

        if (arr[mid] == mid + 1)
            low = mid + 1;

        else
            high = mid;
    }

    return low + 1;
}

int main()
{
    vector<int> arr{1, 2, 3, 5, 6, 7, 8};

    cout << findMissingNumber(arr);

    return 0;
}