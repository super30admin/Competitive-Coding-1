TC-O(LogN)
SC-O(1)
int FindMissingNumber(vector<int>&arr){
    if(arr[0]!=1)return 1;
    int n=arr.size();
    int low=0;
    int high=n-1;
    while(low<=high){
        int mid=low+(high-low)/2;
        if(arr[mid]!=mid+1&&arr[mid-1]==mid)return mid+1;
        else if(arr[mid]==mid+1)low=mid+1;
        else high=mid-1;
    }
    return low;
}


int main() {
vector<int>arr={1,2,3,4,6};
    cout<<FindMissingNumber(arr);
}