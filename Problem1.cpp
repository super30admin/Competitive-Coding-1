int search(vector<int> arr)
{
    // Time Complexity - O(n)
    // Space Complexity - S(1)
    int size = arr.size();
    if (ar[0] != 1)
        return 1;
    if (ar[size - 1] != (size + 1))
        return size + 1;
 
    int low = 0, high = size - 1;
    int mid;
    while(low<high){
        if(arr[mid] == mid +1) low = mid+1;
        else high = mid;
    }
    return (arr[high] + 1);
}
