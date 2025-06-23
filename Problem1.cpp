// Given a sorted array arr[] of n-1 integers, these integers are in the range of 1 to n. There are no duplicates in the array. One of the integers is missing in the array. Write an efficient code to find the missing integer. 
// Examples: 

// Input : arr[] = [1, 2, 3, 4, 6, 7, 8]
// Output : 5
// Explanation: The missing integer in the above array is 5 

// Input : arr[] = [1, 2, 3, 4, 5, 6, 8, 9]
// Output : 7
// Explanation: The missing integer in the above array is 7 

//time complexity -O(logn);
//space complexity - O(1);

#include <iostream>
using namespace std;

int binarysearch(int *arr, int low, int high){
    while(low <= high){
        int mid = low + ((high-low)/2);
        if(arr[mid] != mid + 1){
            high = mid - 1;            
        }
        else{
            low = mid + 1;
        }
    }
    return low + 1;
}

int main(){
    int arr[7] = {2,3,4,5,6,7,8};
    cout << binarysearch(arr, 0, 6) << endl;
}
