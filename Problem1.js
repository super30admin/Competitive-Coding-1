//Time Complexity: O (log n)
//Space Complexity: O (1)
//Runs: yes

function searchMissingElem(arr) {
    let low = 0, high = arr.length - 1;
    while (low <= high) {
        const mid = Math.floor(low + (high - low) / 2);
        if ((arr[mid] - mid) > 1) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    console.log(low + 1);
}

searchMissingElem([1, 2, 4, 5, 6, 7, 8, 9])