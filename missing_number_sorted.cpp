int main() {
    int arr[] ={1,2,3,4,6,7};
    int n=6;
    int diff=arr[0];
    int low=0;
    int high=n-1;
    int mid;
    while(low<=high)
    {
        mid=low+(high-low)/2;
        if(mid==arr[mid]-diff-1&&arr[mid-1]!=arr[mid]-1)
        {
            cout<<arr[mid]-1<<endl;
            return 1;
        }
        else if(mid==arr[mid]-diff)
        {
            low=mid+1;
        }
        else
            high=mid-1;
    }
}