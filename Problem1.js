// Using Binary Search
// Time Complexity O(logn)
// Space Complexity O(1)
function missingElement(arr) {
        let start = 0;
        let end = arr.length - 1;
        if (arr === undefined || arr.length == 0) {
            return -1
        }
        while( start <= end) {
            let mid = (start + (end-start))/2;
            // Check with the array index and difference should be one
            if(mid == arr[mid] -1) {
                start = mid +1;
            }
            else {
                end = mid -1;
            }
        }
        return start+1;
    }