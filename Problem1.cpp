// Time complexity: O(logn)
//Space Complexity: O(1)
//Code ran successfully on geeksforgeeks

//Approach:
// Since array is sorted we can use the index and check corresponding element. 
// Difference should be 1. If it is then move right.
// Else move left.


// A binary search based program to find the
// only missing number in a sorted array of
// distinct elements within limited range.
#include <iostream>
using namespace std;

int search(int ar[], int size)
{
    // Extreme cases
    if (ar[0] != 1)
        return 1;
    if (ar[size - 1] != (size + 1))
        return size + 1;

    int left = 0;
  	int right = size - 1;
  	int mid = 0;
  	while(left <= right){
    	mid = left + (right - left)/2;
      	if(ar[mid] - mid == 1){left = mid + 1;}
      	else{right = mid - 1;}
    }
  	return left + 1;
  	
}

int main()
{
    int ar[] = { 1, 3, 4, 5, 6, 7, 8 };
    int size = sizeof(ar) / sizeof(ar[0]);
    cout << "Missing number:" << search(ar, size);
}
