int missing(vector<int> arr, int size)
{
    int low = 0, high = size - 1, mid;
    while(low<=high)
    {
        mid = low + (high - low) / 2;
        if(arr[mid] - arr[mid - 1] != 1)
                return arr[mid] - 1;
        if((arr[mid] - mid) != arr[0])
        {
            high = mid - 1;
        }
        else
            low = mid + 1;
    }
    return  - 1;
}
