// Time Complexity : O(log n)
// Space Complexity : O(1)


#include<iostream>

using namespace std;

int binarySearch(int arr[], int low, int high,int n){
    while(low <= high){

        int mid = low + (high - low)/ 2;

        if(arr[mid]-mid != 1 && arr[mid-1] == mid) {
            return mid + 1;
        }

        else if(arr[mid -1] == mid){    // check if the left side is valid 
            low = mid + 1;
        }
        else{           //the right side is valid so search the left
            high = mid - 1;
        }    
    }

    return -1;
}


int main(){
    int arr[] = {1,2,3,5,6,7,8,9,10,11,12};      // sample array 
    int arrsize = sizeof(arr)/sizeof(arr[0]);
    int low = 0;
    int high = arrsize-1;
    

    int missingNumber = binarySearch(arr,low,high,arrsize); // call to binarySearch to return missing number
    cout<<"\n"<<missingNumber; 
    return 0;
}