
#include<iostream>
using namespace std;
int helper(int arr[], int low, int high){
    while(low<=high){
        int mid = low +(high-low)/2;
        if(arr[mid]==mid+1){
            low=mid+1;
        }
        else if(mid==0){
            if(arr[mid]!=1)
                return 1; 
        }
        else if(arr[mid]!=mid+1&&arr[mid-1]==mid){
            return arr[mid]-1;
        }
        else
        {
            high = mid-1;
        }
    }
    return -1;
}
int main(){
    int arr[7] = {1,2,3,4,5,6,7};
    cout<<helper(arr,0,6);
}