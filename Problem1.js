// Time Complexity : O(log n)
// Space Complexity : O(1) 
// Approach : arr from 0 - N , applying binary search by comparing index

function missingElement(arr) {
    if (arr == null || arr.length == 0) return -1
    let low = 0
    let high = arr.length - 1
    while (low <= high) {
        const mid = Math.floor(low + (high - low) / 2)
        if (arr[mid] == mid + 1) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    return low + 1;
}