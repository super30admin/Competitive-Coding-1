// Find Missing Number in a sorted array

// Approach: first check for the extreme cases where either 1 or last element is missing. then if arr[low] - low != arr[mid] - mid, high = mid, else, low = mid. keep doing till only 2 elements remain. number 1 greater than the first element will be the ans.
// Time: O(log n)
// Space: O(1)

int search(int ar[], int size)
{
    // Extreme cases
    if (ar[0] != 1)
        return 1;
    if (ar[size - 1] != (size + 1))
        return size + 1;

    int a = 0, b = size - 1;
    int mid;
    while ((b - a) > 1) {
        mid = (a + b) / 2;
        if ((ar[a] - a) != (ar[mid] - mid))
            b = mid;
        else if ((ar[b] - b) != (ar[mid] - mid))
            a = mid;
    }
    return (ar[a] + 1);
}

int main()
{
    int ar[] = { 1, 2, 3, 4, 5, 6 };
    int size = sizeof(ar) / sizeof(ar[0]);
    cout << "Missing number:" << search(ar, size);
}

// My solution in the interview:

// int missingElement (vector<int> &arr) {
//     int l = 0, h = arr.size()-1;
//     while(l <= h) {
//         int mid = l + (h-l)/2;
//         if(mid == 0) {
//             return arr[mid]+1;
//         }
//         else if(arr[mid] != (arr[mid-1]+1)) {
//             return arr[mid]-1;
//         }
//         else if((mid-l) != (arr[mid]-arr[l])) {
            
//             h = mid-1;
//         }
//         else {
//             l = mid+1;
//         }
        
//     }
//     return 0;
// }

// int main() {
//     vector<int> arr = {1,3,4,5,6,7};
//     cout<<"missing element is "<<missingElement(arr);
// }
